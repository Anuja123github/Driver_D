package com.driver.service;

import java.time.LocalDate;
import java.util.List;

import com.driver.model.DriverLicenseDetails;

public interface DriverLicenseDetailsService {

	public DriverLicenseDetails saveDriverLicenseDetails(DriverLicenseDetails driverLicenseDetails);

	public DriverLicenseDetails updateDriverLicenseDetails(DriverLicenseDetails driverLicenseDetails);

	public DriverLicenseDetails getDriverLicenseDetails(Integer id);

	public void deleteDriverLicenseDetails(Integer id);

	public List<DriverLicenseDetails> getAllDriverLicenseDetails();

	public DriverLicenseDetails getLicenseDetailsBySsn(String ssn);

	public DriverLicenseDetails getLicenseDetailsByIssuedDate(LocalDate licenseIssuedDate);

	public List<DriverLicenseDetails> getLicenseDetailsByIssuedState(String licenseIssuedState);

	public DriverLicenseDetails getLicenseDetailsByLicenseNumber(String licenseNumber);
}
