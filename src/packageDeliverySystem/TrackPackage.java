package packageDeliverySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackPackage {
	
	private int trackingId;
	private Connection connect = null;
	private ResultSet rs = null;
	private PreparedStatement ps, ps1;
	final private String host = "localhost"; 
	final private String user = "root";
	final private String passwd = "root";
	final private String getShippingDetailsQuery = "SELECT * FROM himanshu.track_package WHERE tracking_number=? ORDER BY arrivalTime DESC";
	final private String getPackageDetailsQuery ="SELECT * FROM himanshu.package_details WHERE tracking_number=?";
	private PackageModel packageModel;
	private PackageShipModel packageShipModel;
	
	
	public TrackPackage() {
		
	}
	public TrackPackage(int id) {
		this.trackingId = id;
	}

	public PackageModel getShippingDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/himanshu?"+ "user=" + user + "&password=" + passwd );
			packageModel = new PackageModel();
			ps = connect.prepareStatement(getPackageDetailsQuery);
			ps.setInt(1,trackingId);
			rs = ps.executeQuery();
			while ( rs.next() ){
				packageModel.setTrackingId(trackingId);
				packageModel.setSource(rs.getString("source"));
				packageModel.setDestination(rs.getString("destination"));
				packageModel.setWeight(rs.getString("weight"));
				packageModel.setPackageType(rs.getString("package_Type"));
				packageModel.setSenderName(rs.getString("senderName"));
				packageModel.setReceiverName(rs.getString("receiverName"));
				packageModel.setQuantity(rs.getString("quantity"));
				packageModel.setSignatureRequired(rs.getBoolean("signature_required"));
				packageModel.setSpecialServices(rs.getString("specialServices"));
				packageModel.setCreatedDate(rs.getTimestamp("createDate"));
				packageModel.setUpdatedDate(rs.getTimestamp("updateDate"));
			}
			
			ArrayList<PackageShipModel> list = new ArrayList<>();
			
			ps1 = connect.prepareStatement(getShippingDetailsQuery);
			ps1.setInt(1,trackingId);
			rs = ps1.executeQuery();
			while ( rs.next() ){
				PackageShipModel packageShipModel = new PackageShipModel(rs.getString("center_name"), rs.getTimestamp("arrivalTime"), rs.getTimestamp("departureTime"));
				list.add(packageShipModel);
		    }
			packageModel.setShippingList(list);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return packageModel;
		
	}
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (ps1 != null) {
				ps1.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
