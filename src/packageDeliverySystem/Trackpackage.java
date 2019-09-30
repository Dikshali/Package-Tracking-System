package packageDeliverySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trackpackage extends Thread{
	List<Vertex> path = new ArrayList<Vertex>();
	int trackingId;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String Inserttotrackdetails = "insert into himanshu.track_package(tracking_number, center_name, arrivalTime, departureTime)values (?,?,?,?)";
	final private String updatetrackdetails = "update himanshu.track_package set departureTime = ? where tracking_number = ? and center_name = ?";
	final private String host = "localhost"; 
	final private String user = "root";
	final private String passwd = "root"; 

	public Trackpackage() {

	}

	public Trackpackage(List<Vertex> path, int trackId) {
		this.trackingId = trackId;
		this.path = path;
	}
	public void run() {
		try {
			for(int i=0; i<path.size();i++) {
				insertCenter(path.get(i));
				Thread.sleep(15000);
				updateCenter(path.get(i));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public void insertCenter(Vertex vertex) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
			preparedStatement = connect.prepareStatement(Inserttotrackdetails);
			preparedStatement.setInt(1,trackingId);
			preparedStatement.setString(2,vertex.name); 
			preparedStatement.setTimestamp(3,new Timestamp(new Date().getTime()));
			preparedStatement.setTimestamp(4,new Timestamp(new Date().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
public void updateCenter(Vertex vertex) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
			preparedStatement = connect.prepareStatement(updatetrackdetails);
			preparedStatement.setTimestamp(1,new Timestamp(new Date().getTime()));
			preparedStatement.setInt(2,trackingId);
			preparedStatement.setString(3,vertex.name); 
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
