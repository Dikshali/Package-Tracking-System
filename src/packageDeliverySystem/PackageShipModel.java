package packageDeliverySystem;

import java.sql.Timestamp;

public class PackageShipModel {
	private int trackingId;
	private String centerName;
	private Timestamp arrivalTime;
	private Timestamp departureTime;
	public PackageShipModel() {
		
	}
	
	public PackageShipModel(String centerName, Timestamp arrivalTime, Timestamp departureTime) {
		this.centerName = centerName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	public PackageShipModel(int trackingId, String centerName, Timestamp arrivalTime, Timestamp departureTime) {
		this.trackingId = trackingId;
		this.centerName = centerName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public int getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Timestamp getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
}
