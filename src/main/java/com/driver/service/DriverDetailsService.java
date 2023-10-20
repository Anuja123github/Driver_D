package com.driver.service;

import com.driver.model.DriverDetails;

public interface DriverDetailsService {
	public DriverDetails saveDriverDetails(DriverDetails driverDetails);
	public DriverDetails getDriverDetails(Integer id);

}
