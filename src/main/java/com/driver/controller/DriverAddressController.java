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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class DriverAddressController {
	@Autowired
	private DriverAddressDetails addressDetails;
	
	@PostMapping("/addDriverAddress")
	@ApiOperation(value = "Request to add address details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public DriverAddress addDetails (@RequestBody DriverAddress driverAddress) {
		
		DriverAddress add = addressDetails.addDetails(driverAddress);
		return add;
		
	}
	
	@GetMapping("/getDriverAddress/{id}")
	@ApiOperation(value = "Request to get address details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public DriverAddress getDetails (@PathVariable ("Id")Integer id) {
	DriverAddress get =	addressDetails.getDetails(id);
	return get;
	}
	
	@PutMapping("/updateDriverAddress")
	@ApiOperation(value = "Request to update address details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public DriverAddress updateDetails  (@RequestBody DriverAddress driverAddress) {
		DriverAddress update = addressDetails.updateDetails(driverAddress);
		return update;
	}
	
	@DeleteMapping("/deleteDriverAddress/{id}")
	@ApiOperation(value = "Request to delete address details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public void deleteDetails (@PathVariable ("id") Integer id) {
		addressDetails.deleteDetails(id);
	}
	
	@GetMapping("/searchDriverByCity/{city}")
	@ApiOperation(value = "Request to get address details using city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public DriverAddress findByCity (@RequestParam ("city") String city) {
		DriverAddress search = addressDetails.findByCity(city);
		return search;
	}

}
