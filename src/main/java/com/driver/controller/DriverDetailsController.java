package com.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.driver.model.DriverDetails;
import com.driver.service.DriverDetailsService;

@RestController
public class DriverDetailsController {

	// inject service
	@Autowired
	private DriverDetailsService driverDetailsService;

	@PostMapping("addDriverDetails")
	public ResponseEntity<DriverDetails> saveDriverDetails(@RequestBody DriverDetails driverDetails) {
		DriverDetails driverDetails1 = driverDetailsService.saveDriverDetails(driverDetails);
		return ResponseEntity.ok().body(driverDetails1);
	}

	@GetMapping("/getDriverDetails/{id}")
	public ResponseEntity<DriverDetails> getDriverDetails(@PathVariable("id") Integer id) {
		DriverDetails driverDetails = driverDetailsService.getDriverDetails(id);
		return ResponseEntity.ok().body(driverDetails);

	}

}
