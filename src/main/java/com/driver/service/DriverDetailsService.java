package com.driver.service;

import java.util.List;
import java.util.Optional;

import com.driver.model.DriverDetails;

public interface DriverDetailsService {
	
	public DriverDetails saveDriverDetails(DriverDetails driverDetails);
	
	public DriverDetails getDriverDetails(Integer id);
	
	public DriverDetails updateDriverDetails(DriverDetails driverDetails);
	
	public void deleteDriverDetails(Integer id);
	
	public DriverDetails getByPolicyId(Integer policyId);
	
	public List<DriverDetails> getByFirstname(String firstname);
	
	public List<DriverDetails> getByLastname(String lastname);
	
	public List<DriverDetails> getByFirstnameAndLastname(String firstname, String lastname);
	
	public DriverDetails getByEmail(String email);
	
	public DriverDetails getByMobile(String mobile);
}
