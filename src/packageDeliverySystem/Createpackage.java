package packageDeliverySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Createpackage {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost"; //172.20.4.13  3306   127.0.0.1
	final private String user = "root";
	final private String passwd = "root"; //Himanshu7&
	
	final private String Inserttopackagedetails = "insert into himanshu.package_details (senderName,receiverName,source,destination,package_Type,weight,quantity,signature_required,specialServices,createDate,updateDate)values (?,?,?,?,?,?,?,?,?,?,?)";
	final private String Inserttotrackdetails = "insert into himanshu.track_package(tracking_number,center_name)values (?,?)";
	
	String trackingNumber="";
	String weight="";
	boolean signatureRequired=false;
	String packageType="";
	String quantity="";
	String senderName="";
	String receiverName="";
	String source="";
	String destination="";
	String specialServices="";
	
	List<Map<String, Object>> cities = new ArrayList<Map<String, Object>>();
	ArrayList<String> sourceCities= new ArrayList<String>();
	ArrayList<String> destCities= new ArrayList<String>();
	
	public void getCenters() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from himanshu.center_list");
		//writeResultSet(resultSet);
		while (resultSet.next()) {
			String center_id = resultSet.getString("center_id");
			String center_name = resultSet.getString("center_name");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", center_id);
			map.put("center", center_name);
			cities.add(map);
			sourceCities.add(center_name);
		}
		for(int i=0; i<sourceCities.size(); i++) {
			System.out.println("cities are:"+sourceCities.get(i));
		}

	}
	
	public int insertPackage(String senderName,String receiverName,String source,String destination,
			String packageType, String weight, String quantity,boolean signatureRequired,String specialServices ) throws Exception{
		int tracking_number=0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
		
		preparedStatement = connect.prepareStatement(Inserttopackagedetails,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1,senderName); 
		preparedStatement.setString(2,receiverName); 
		preparedStatement.setString(3,source);
		preparedStatement.setString(4,destination);
		preparedStatement.setString(5,packageType); 
		preparedStatement.setString(6,weight); 
		preparedStatement.setString(7,quantity); 
		preparedStatement.setBoolean(8, signatureRequired);
		preparedStatement.setString(9,specialServices); 
		java.sql.Timestamp d = new java.sql.Timestamp(new Date().getTime());
		preparedStatement.setTimestamp(10,d); 
		preparedStatement.setTimestamp(11,d); 
		int rowsAffected = preparedStatement.executeUpdate();
		if(rowsAffected>0) {
			resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				tracking_number = resultSet.getInt(1);
			}
			
		}
		
			/*
			 * preparedStatement = connect.
			 * prepareStatement("select tracking_number from himanshu.package_details where senderName=? and createDate=?"
			 * ); preparedStatement.setString(1, senderName);
			 * preparedStatement.setTimestamp(2, d); resultSet=
			 * preparedStatement.executeQuery();
			 */

		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(tracking_number);
		return tracking_number;
	}
	
	public void createPath(String source, String destination, int result) throws Exception{
		Shortest s = new Shortest();
        Vertex v =new Vertex();
        ArrayList<Vertex> cityList = new ArrayList<>();
        cityList = v.createGraph();
        for(int i=0;i<cityList.size();i++) {
        	Vertex src = cityList.get(i);
        	if(src.name.equalsIgnoreCase(source)) {
        		s.computePaths(src);
        		break;
        	}
        }
        List<Vertex> path = new ArrayList<>();
        for(int i=0;i<cityList.size();i++) {
        	Vertex dst = cityList.get(i);
        	
        	if(dst.name.equalsIgnoreCase(destination)) {
        		path=s.getShortestPathTo(dst);
        		break;
        	}
        }
        System.out.println("Path: "+ path);
        Trackpackage package1 = new Trackpackage(path, result);
        package1.start();
        
        
//		final List<Vertex> path1 = path;
//        new Thread() {
//        	public void run() {
//        		try {
//        			for(int i=0; i<path1.size();i++) {
//        				Thread.sleep(15);
//        	        	Class.forName("com.mysql.cj.jdbc.Driver");
//        	    		connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
//        	    		preparedStatement = connect.prepareStatement(Inserttotrackdetails);
//        	    		preparedStatement.setInt(1,result);
//        	    		preparedStatement.setString(2,path1.get(i).toString()); 
//        	    		preparedStatement.executeUpdate();
//        	        }
//					//TimeUnit.SECONDS.sleep(15);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        	}
//        }.start();
        
        
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "/himanshu?"
							+ "user=" + user + "&password=" + passwd );
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from himanshu.center_list");
			//System.out.println(resultSet);
			writeResultSet(resultSet);
			/*
			 * preparedStatement = connect
			 * .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)"
			 * );
			 * 
			 * preparedStatement.setString(1, "Test"); preparedStatement.setString(2,
			 * "TestEmail"); preparedStatement.setString(3, "TestWebpage");
			 * preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
			 * preparedStatement.setString(5, "TestSummary"); preparedStatement.setString(6,
			 * "TestComment"); preparedStatement.executeUpdate();
			 * 
			 * preparedStatement = connect
			 * .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments"
			 * ); resultSet = preparedStatement.executeQuery(); writeResultSet(resultSet);
			 * 
			 * preparedStatement = connect
			 * .prepareStatement("delete from feedback.comments where myuser= ? ; ");
			 * preparedStatement.setString(1, "Test"); preparedStatement.executeUpdate();
			 * 
			 * resultSet = statement.executeQuery("select * from feedback.comments");
			 */
			//writeMetaData(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String user = resultSet.getString("center_id");
			String website = resultSet.getString("center_name");
//			String summary = resultSet.getString("summary");
//			Date date = resultSet.getDate("datum");
//			String comment = resultSet.getString("comments");
			//System.out.println("User: " + user);
			System.out.println(website);
//			System.out.println("Summary: " + summary);
//			System.out.println("Date: " + date);
//			System.out.println("Comment: " + comment);
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
