package com.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driver.model.DriverAddress;
import com.driver.service.DriverAddressDetails;

@RestController

public class DriverAddressController {
	@Autowired
	private DriverAddressDetails addressDetails;
	
	@PostMapping("/addDriverAddress")
	public DriverAddress addDetails (@RequestBody DriverAddress driverAddress) {
		
		DriverAddress add = addressDetails.addDetails(driverAddress);
		return add;
		
	}
	@GetMapping("/getDriverAddress/{id}")
	public DriverAddress getDetails (@PathVariable ("Id")Integer id) {
	DriverAddress get =	addressDetails.getDetails(id);
	return get;
	}
	@PutMapping("/updateDriverAddress")
	public DriverAddress updateDetails  (@RequestBody DriverAddress driverAddress) {
		DriverAddress update = addressDetails.updateDetails(driverAddress);
		return update;
	}
	@DeleteMapping("/deleteDriverAddress/{id}")
	public void deleteDetails (@PathVariable ("id") Integer id) {
		addressDetails.deleteDetails(id);
	}
	@GetMapping("/searchDriverByCity/{city}")
	public DriverAddress findByCity (@RequestParam ("city") String city) {
		DriverAddress search = addressDetails.findByCity(city);
		return search;
	}

}
