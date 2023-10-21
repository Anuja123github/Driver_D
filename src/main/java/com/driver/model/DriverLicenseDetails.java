package com.driver.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_license_details")
public class DriverLicenseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String SSN;
	private Date licenseIssuedDate;
	private String licenseIssuedState;
	private String licenseNumber;
	private String gender;
	private String maritialStatus;

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public Date getLicenseIssuedDate() {
		return licenseIssuedDate;
	}

	public void setLicenseIssuedDate(Date licenseIssuedDate) {
		this.licenseIssuedDate = licenseIssuedDate;
	}

	public String getLicenseIssuedState() {
		return licenseIssuedState;
	}

	public void setLicenseIssuedState(String licenseIssuedState) {
		this.licenseIssuedState = licenseIssuedState;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	@Override
	public String toString() {
		return "DriverLicenseDetails [SSN=" + SSN + ", licenseIssuedDate=" + licenseIssuedDate + ", licenseIssuedState="
				+ licenseIssuedState + ", licenseNumber=" + licenseNumber + ", gender=" + gender + ", maritialStatus="
				+ maritialStatus + "]";
	}

}
