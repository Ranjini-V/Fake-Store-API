package pojo;

public class Address {

	public String city;
	public String street;
	public String number;
	public String zipcode;
	public GeoLocation geolocation;

	public Address(String city, String street, String number, String zipcode, GeoLocation geolocation) {
		super();
		this.city = city;
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.geolocation = geolocation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public GeoLocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeoLocation geolocation) {
		this.geolocation = geolocation;
	}

}
