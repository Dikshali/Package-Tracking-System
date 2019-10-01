package packageDeliverySystem;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PackageModel {
	
	private int trackingId;
	private String weight;
	private boolean signatureRequired=false;
	private String packageType;
	private String quantity;
	private String senderName;
	private String receiverName;
	private String source;
	private String destination;
	private String specialServices;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	ArrayList<PackageShipModel> shippingList = new ArrayList<>();
	
	public PackageModel() {
		
	}
	
	public PackageModel(String senderName,String receiverName,String source,String destination,
			String packageType, String weight, String quantity,boolean signatureRequired,String specialServices, Timestamp createdDate, Timestamp updatedDate) {
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.source = source;
		this.destination = destination;
		this.packageType = packageType;
		this.weight = weight;
		this.quantity = quantity;
		this.signatureRequired = signatureRequired;
		this.specialServices = specialServices;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public ArrayList<PackageShipModel> getShippingList() {
		return shippingList;
	}

	public void setShippingList(ArrayList<PackageShipModel> shippingList) {
		this.shippingList = shippingList;
	}

	public int getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public boolean isSignatureRequired() {
		return signatureRequired;
	}

	public void setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSpecialServices() {
		return specialServices;
	}

	public void setSpecialServices(String specialServices) {
		this.specialServices = specialServices;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	
}
