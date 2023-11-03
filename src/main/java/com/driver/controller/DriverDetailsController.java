package com.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driver.dto.ApiResponseDto;
import com.driver.dto.DriverDetailsDto;
import com.driver.model.DriverDetails;
import com.driver.service.DriverDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DriverDetailsController {

	// inject service
	@Autowired
	private DriverDetailsService driverDetailsService;

	@PostMapping("/addDriverDetails")
	@ApiOperation(value = "Request to save Driver details with address and license details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> saveDriverDetails(@RequestBody DriverDetails driverDetails) {
		
		DriverDetails driverDetails1 = driverDetailsService.saveDriverDetails(driverDetails);
		return ResponseEntity.ok().body(driverDetails1);
	}
	
	@PutMapping("/updateDriverDetails")
	@ApiOperation(value = "Request to update Driver details with address and license details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> updateDriverDetails(@RequestBody DriverDetails driverDetails) {
		
		DriverDetails driverDetails1 = driverDetailsService.updateDriverDetails(driverDetails);
		return ResponseEntity.ok().body(driverDetails1);
	}

	@GetMapping("/getDriverDetails/{id}")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> getDriverDetails(@PathVariable("id") Integer id) {
		
		DriverDetails driverDetails = driverDetailsService.getDriverDetails(id);
		return ResponseEntity.ok().body(driverDetails);
	}

	@DeleteMapping("/deleteDriverDetails/{id}")
	@ApiOperation(value = "Request to delete driver details with address and license details using driver id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<ApiResponseDto> deleteDriverDetails(@PathVariable("id") Integer id) {
		
		driverDetailsService.deleteDriverDetails(id);;
		return ResponseEntity.ok().body(new ApiResponseDto("record deleted successfully"));
	}
	
	@GetMapping("/getDriverDetails/byPolicyId")
	@ApiOperation(value = "Request to get Driver details with address and license details using policy id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> getByPolicyId(@RequestParam("id") Integer policyId) {
		
		DriverDetails driverDetails = driverDetailsService.getByPolicyId(policyId);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byFirstname")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver firstname")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<List<DriverDetails>> getByFirstname(@RequestParam("firstname") String firstname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByFirstname(firstname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byLastname")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver lastname")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<List<DriverDetails>> getByLastname(@RequestParam("lastname") String lastname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByLastname(lastname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byFirstnameAndLastname")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver firstname and lastname")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<List<DriverDetails>> getByFirstnameAndLastname(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
		
		List<DriverDetails> driverDetails = driverDetailsService.getByFirstnameAndLastname(firstname, lastname);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byEmail")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> getByEmail(@RequestParam("email") String email) {
		
		DriverDetails driverDetails = driverDetailsService.getByEmail(email);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverDetails/byMobile")
	@ApiOperation(value = "Request to get Driver details with address and license details using driver mobile number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetails> getByMobile(@RequestParam("mobile") String mobile) {
		
		DriverDetails driverDetails = driverDetailsService.getByMobile(mobile);
		return ResponseEntity.ok().body(driverDetails);
	}
	
	@GetMapping("/getDriverPolicyDetails/{id}")
	@ApiOperation(value = "Request to get Driver details with policy details using driver id. This is dependent on Inusrance_D")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public ResponseEntity<DriverDetailsDto> getDriverPolicyDetails(@PathVariable("id") Integer id) {
		
		DriverDetailsDto detailsDto = driverDetailsService.getDriverPolicyDetails(id);
		return ResponseEntity.ok().body(detailsDto);
	}
}
