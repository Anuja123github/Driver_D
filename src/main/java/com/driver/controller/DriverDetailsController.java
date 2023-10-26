package com.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driver.dto.ApiResponseDto;
import com.driver.model.DriverDetails;
import com.driver.service.DriverDetailsService;

@RestController
public class DriverDetailsController {

	// inject service
	@Autowired
	private DriverDetailsService driverDetailsService;

	@PostMapping("/addDriverDetails")
	public ResponseEntity<DriverDetails> saveDriverDetails(@RequestBody DriverDetails driverDetails) {
		
		DriverDetails driverDetails1 = driverDetailsService.saveDriverDetails(driverDetails);
		return ResponseEntity.ok().body(driverDetails1);
	}
	
	public ResponseEntity<DriverDetails> updateDriverDetails(@RequestBody DriverDetails driverDetails) {
		
		DriverDetails driverDetails1 = driverDetailsService.updateDriverDetails(driverDetails);
		return ResponseEntity.ok().body(driverDetails1);
	}

	@GetMapping("/getDriverDetails/{id}")
	public ResponseEntity<DriverDetails> getDriverDetails(@PathVariable("id") Integer id) {
		
		DriverDetails driverDetails = driverDetailsService.getDriverDetails(id);
		return ResponseEntity.ok().body(driverDetails);
	}

	@DeleteMapping("/deleteDriverDetails/{id}")
	public ResponseEntity<ApiResponseDto> deleteDriverDetails(@PathVariable("id") Integer id) {
		
		driverDetailsService.deleteDriverDetails(id);;
		return ResponseEntity.ok().body(new ApiResponseDto("record deleted successfully"));
	}
	
	@GetMapping("/getDriverDetails/byPolicyId")
	public ResponseEntity<DriverDetails> getByPolicyId(@RequestParam("id") Integer policyId) {
		
		DriverDetails driverDetails = driverDetailsService.getByPolicyId(policyId);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byFirstname")
	public ResponseEntity<List<DriverDetails>> getByFirstname(@RequestParam("firstname") String firstname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByFirstname(firstname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byLastname")
	public ResponseEntity<List<DriverDetails>> getByLastname(@RequestParam("lastname") String lastname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByLastname(lastname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byFirstnameAndLastname")
	public ResponseEntity<List<DriverDetails>> getByFirstnameAndLastname(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByFirstnameAndLastname(firstname, lastname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byEmail")
	public ResponseEntity<DriverDetails> getByEmail(@RequestParam("email") String email) {
		
		DriverDetails driverDetails = driverDetailsService.getByEmail(email);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byMobile")
	public ResponseEntity<DriverDetails> getByMobile(@RequestParam("mobile") String mobile) {
		
		DriverDetails driverDetails = driverDetailsService.getByMobile(mobile);
		return ResponseEntity.ok().body(driverDetails);
	}
}
