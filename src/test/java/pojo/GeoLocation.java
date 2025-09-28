package pojo;

public class GeoLocation {

	public String lat;
	public String longi;

	public GeoLocation(String lat, String longi) {
		super();
		this.lat = lat;
		this.longi = longi;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

}
