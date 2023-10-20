package com.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.model.DriverAddress;
import com.driver.service.DriverAddressDetails;

@RestController
public class DriverAddressController {
	@Autowired
	private DriverAddressDetails addressDetails;
	
	@PostMapping("/addDriverAddress")
	public DriverAddress addDetails (DriverAddress driverAddress) {
		
		DriverAddress add = addressDetails.addDetails(driverAddress);
		return add;
		
	}
	@GetMapping("/getDriverAddress")
	public DriverAddress getDetails (Integer id) {
	DriverAddress get =	addressDetails.getDetails(id);
	return get;
	}
	@PutMapping("/updateDriverAddress")
	public DriverAddress updateDetails  (DriverAddress driverAddress) {
		DriverAddress update = addressDetails.updateDetails(driverAddress);
		return update;
	}
	@DeleteMapping("/deleteDriverAddress")
	public void deleteDetails (Integer id) {
		addressDetails.deleteDetails(id);
	}
	@GetMapping("/searchDriverByCity")
	public DriverAddress findByCity (String city) {
		DriverAddress search = addressDetails.findByCity(city);
		return search;
	}

}
