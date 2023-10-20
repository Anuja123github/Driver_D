package com.driver.service;

import com.driver.model.DriverAddress;

public interface DriverAddressDetails {
	
	public DriverAddress addDetails (DriverAddress driverAddress);
	
	public DriverAddress getDetails (Integer id);
	
	public DriverAddress updateDetails  (DriverAddress driverAddress);
	
	public void deleteDetails (Integer id);
	
	public DriverAddress findByCity (String city);

}
