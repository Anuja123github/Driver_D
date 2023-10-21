package com.driver.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.DriverDetails;
import com.driver.repository.DriverDetailsRepository;
import com.driver.service.DriverDetailsService;

@Service
public class DriverDetailsServiceimpl implements DriverDetailsService {
//inject repository
	@Autowired
	private DriverDetailsRepository driverRepository;
	@Override
	public DriverDetails saveDriverDetails(DriverDetails driverDetails) {
		DriverDetails driverDetails1=driverRepository.save(driverDetails);
		return driverDetails1;
	}

	@Override
	public DriverDetails getDriverDetails(Integer id) {
		DriverDetails driverDetails=driverRepository.findById(id).get();
		return driverDetails;
	}

}
