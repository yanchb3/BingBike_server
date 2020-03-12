package bike.object;

public class Bike {
	//string 6位 000 000
	private String id;
	private double longitude;
	private double latitude;
	//0：正常未使用， 1：正常使用中  2：维修
	private int status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLongtitude() {
		return longitude;
	}
	public void setLongtitude(double longtitude) {
		this.longitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
