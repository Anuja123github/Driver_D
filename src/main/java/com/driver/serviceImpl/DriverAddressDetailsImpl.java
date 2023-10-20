package com.driver.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.DriverAddress;
import com.driver.repository.DriverAddressRepository;
import com.driver.service.DriverAddressDetails;

@Service
public class DriverAddressDetailsImpl implements DriverAddressDetails {
	@Autowired
	private DriverAddressRepository driverAddressRepository;

	@Override
	public DriverAddress addDetails(DriverAddress driverAddress) {
		DriverAddress add = driverAddressRepository.save(driverAddress);
		return add;
	}

	@Override
	public DriverAddress getDetails(Integer id) {
	return driverAddressRepository.findById(id).orElse(null);
	
	}

	@Override
	public DriverAddress updateDetails(DriverAddress driverAddress) {
		DriverAddress update = driverAddressRepository.save(driverAddress);
		return update;
	}

	@Override
	public void deleteDetails(Integer id) {
		driverAddressRepository.deleteById(id);
		
	}

	@Override
	public DriverAddress findByCity(String city) {
	DriverAddress search =	driverAddressRepository.findByCity(city);
		return  search;
	}

}
