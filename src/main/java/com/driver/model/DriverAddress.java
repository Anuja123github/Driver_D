package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="driverDetails")
public class DriverAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int DriverId;
	private String Address;
	private String city;
	private String state;
	private String ZipCode;
	private String Country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDriverId() {
		return DriverId;
	}
	public void setDriverId(int driverId) {
		DriverId = driverId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	@Override
	public String toString() {
		return "DriverAddress [id=" + id + ", DriverId=" + DriverId + ", Address=" + Address + ", city=" + city
				+ ", state=" + state + ", ZipCode=" + ZipCode + ", Country=" + Country + "]";
	}

	

}
