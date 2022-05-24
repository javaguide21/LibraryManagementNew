package com.dto;

public class Address {
	private String streetNo;
	private String streetName;
	private String city;
	private String district;
	private long pincode;
	public static final String COUNTRY="INDIA";
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public Address(String streetNo, String streetName, String city, String district, long pincode) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.district = district;
		this.pincode = pincode;
	}
	
public Address() {
}
	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", streetName=" + streetName + ", city=" + city + ", district="
				+ district + ", pincode=" + pincode + "]";
	}
	

}
