package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driverDetails")
public class DriverDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int policyId;
	private String firstname;
	private String lastname;
	private String Dob;
	private String email;
	private String mobile;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private DriverAddress driverAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private DriverLicenseDetails driverLicenseDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public DriverAddress getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(DriverAddress driverAddress) {
		this.driverAddress = driverAddress;
	}

	public DriverLicenseDetails getDriverLicenseDetails() {
		return driverLicenseDetails;
	}

	public void setDriverLicenseDetails(DriverLicenseDetails driverLicenseDetails) {
		this.driverLicenseDetails = driverLicenseDetails;
	}

	@Override
	public String toString() {
		return "DriverDetails [id=" + id + ", policyId=" + policyId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", Dob=" + Dob + ", email=" + email + ", mobile=" + mobile + ", driverAddress="
				+ driverAddress + ", driverLicenseDetails=" + driverLicenseDetails + "]";
	}

}
