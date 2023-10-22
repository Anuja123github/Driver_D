package com.driver.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driver.dto.ApiResponseDto;
import com.driver.model.DriverLicenseDetails;
import com.driver.service.DriverLicenseDetailsService;

@RestController
@RequestMapping("/icensedetails")
public class DriverLicenseDetailsController {

	@Autowired
	private DriverLicenseDetailsService licenseDetailsService;
	
	@PostMapping("/add")
	public ResponseEntity<DriverLicenseDetails> addDriverLicenseDetails(@RequestBody DriverLicenseDetails driverLicenseDetails) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.saveDriverLicenseDetails(driverLicenseDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(licenseDetails);
	}

	@PutMapping("/update")
	public ResponseEntity<DriverLicenseDetails> changeDriverLicenseDetails(@RequestBody DriverLicenseDetails driverLicenseDetails) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.updateDriverLicenseDetails(driverLicenseDetails);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DriverLicenseDetails> fetchDriverLicenseDetails(@PathVariable("id") Integer id) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getDriverLicenseDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponseDto> removeDriverLicenseDetails(@PathVariable("id") Integer id) {
		
		licenseDetailsService.deleteDriverLicenseDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto("Record is deleted."));
	}

	@GetMapping("/getall")
	public ResponseEntity<List<DriverLicenseDetails>> getAllDriverLicenseDetails() {
		
		List<DriverLicenseDetails> licenseDetailsList = licenseDetailsService.getAllDriverLicenseDetails();
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetailsList);
	}

	@GetMapping("/get/byssn")
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsBySsn(@RequestParam("ssn") String ssn) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsBySsn(ssn);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/byissuedDate")
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsByIssuedDate(@RequestParam("issuedDate") @DateTimeFormat(iso = ISO.DATE) LocalDate licenseIssuedDate) {
		
		
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsByIssuedDate(licenseIssuedDate);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/byissuedState")
	public ResponseEntity<List<DriverLicenseDetails>> getLicenseDetailsByIssuedState(@RequestParam("issuedState") String licenseIssuedState) {
		
		List<DriverLicenseDetails> licenseDetailsList = licenseDetailsService.getLicenseDetailsByIssuedState(licenseIssuedState);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetailsList);
	}

	@GetMapping("/get/bylincenseNumber")
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsByLicenseNumber(@RequestParam("lincenseNumber") String licenseNumber) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsByLicenseNumber(licenseNumber);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}
}
