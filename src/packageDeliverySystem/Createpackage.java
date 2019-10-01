package packageDeliverySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Createpackage {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost"; 
	final private String user = "root";
	final private String passwd = "root";

	final private String Inserttopackagedetails = "insert into himanshu.package_details (senderName,receiverName,source,destination,package_Type,weight,quantity,signature_required,specialServices,createDate,updateDate)values (?,?,?,?,?,?,?,?,?,?,?)";
	private PackageModel packageModel = new PackageModel();

	List<Map<String, Object>> cities = new ArrayList<Map<String, Object>>();
	ArrayList<String> sourceCities= new ArrayList<String>();
	ArrayList<String> destCities= new ArrayList<String>();


	public Createpackage(PackageModel packageModel) {
		this.packageModel = packageModel;
	}

	public int insertPackage() throws Exception{
		int tracking_number=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );

			preparedStatement = connect.prepareStatement(Inserttopackagedetails,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,packageModel.getSenderName()); 
			preparedStatement.setString(2,packageModel.getReceiverName()); 
			preparedStatement.setString(3,packageModel.getSource());
			preparedStatement.setString(4,packageModel.getDestination());
			preparedStatement.setString(5,packageModel.getPackageType()); 
			preparedStatement.setString(6,packageModel.getWeight()); 
			preparedStatement.setString(7,packageModel.getQuantity()); 
			preparedStatement.setBoolean(8,packageModel.isSignatureRequired());
			preparedStatement.setString(9,packageModel.getSpecialServices()); 
			preparedStatement.setTimestamp(10,packageModel.getCreatedDate()); 
			preparedStatement.setTimestamp(11,packageModel.getUpdatedDate()); 
			
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected>0) {
				resultSet = preparedStatement.getGeneratedKeys();
				while(resultSet.next()) {
					tracking_number = resultSet.getInt(1);
				}
			}
			System.out.println("Tracking id "+tracking_number);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return tracking_number;
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
