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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/licensedetails")
public class DriverLicenseDetailsController {

	@Autowired
	private DriverLicenseDetailsService licenseDetailsService;
	
	@PostMapping("/add")
	@ApiOperation(value = "Request to add license details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> addDriverLicenseDetails(@RequestBody DriverLicenseDetails driverLicenseDetails) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.saveDriverLicenseDetails(driverLicenseDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(licenseDetails);
	}

	@PutMapping("/update")
	@ApiOperation(value = "Request to update license details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> changeDriverLicenseDetails(@RequestBody DriverLicenseDetails driverLicenseDetails) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.updateDriverLicenseDetails(driverLicenseDetails);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value = "Request to get license details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> fetchDriverLicenseDetails(@PathVariable("id") Integer id) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getDriverLicenseDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Request to delete license details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<ApiResponseDto> removeDriverLicenseDetails(@PathVariable("id") Integer id) {
		
		licenseDetailsService.deleteDriverLicenseDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto("Record is deleted."));
	}

	@GetMapping("/getall")
	@ApiOperation(value = "Request to get all license details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<List<DriverLicenseDetails>> getAllDriverLicenseDetails() {
		
		List<DriverLicenseDetails> licenseDetailsList = licenseDetailsService.getAllDriverLicenseDetails();
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetailsList);
	}

	@GetMapping("/get/byssn")
	@ApiOperation(value = "Request to get license details using ssn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsBySsn(@RequestParam("ssn") String ssn) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsBySsn(ssn);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/byissuedDate")
	@ApiOperation(value = "Request to get license details using license issued date")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsByIssuedDate(@RequestParam("issuedDate") @DateTimeFormat(iso = ISO.DATE) LocalDate licenseIssuedDate) {
		
		
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsByIssuedDate(licenseIssuedDate);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}

	@GetMapping("/get/byissuedState")
	@ApiOperation(value = "Request to get license details using license issuing state")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<List<DriverLicenseDetails>> getLicenseDetailsByIssuedState(@RequestParam("issuedState") String licenseIssuedState) {
		
		List<DriverLicenseDetails> licenseDetailsList = licenseDetailsService.getLicenseDetailsByIssuedState(licenseIssuedState);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetailsList);
	}

	@GetMapping("/get/bylincenseNumber")
	@ApiOperation(value = "Request to get license details using license number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverLicenseDetails> getLicenseDetailsByLicenseNumber(@RequestParam("lincenseNumber") String licenseNumber) {
		
		DriverLicenseDetails licenseDetails = licenseDetailsService.getLicenseDetailsByLicenseNumber(licenseNumber);
		return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
	}
}
