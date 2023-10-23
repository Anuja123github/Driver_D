package com.driver.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.exception.ResourceNotFoundException;
import com.driver.model.DriverLicenseDetails;
import com.driver.repository.DriverLicenseDetailsRepository;
import com.driver.service.DriverLicenseDetailsService;

@Service
public class DriverLicenseServiceImpl implements DriverLicenseDetailsService {

	@Autowired
	DriverLicenseDetailsRepository licenseRepository;
	
	@Override
	public DriverLicenseDetails saveDriverLicenseDetails(DriverLicenseDetails driverLicenseDetails) {
		
		return licenseRepository.save(driverLicenseDetails);
	}

	@Override
	public DriverLicenseDetails updateDriverLicenseDetails(DriverLicenseDetails driverLicenseDetails) {
		
		Optional<DriverLicenseDetails> returnedOption = licenseRepository.findById(driverLicenseDetails.getId());
		if (returnedOption.isPresent()) {
			return licenseRepository.save(driverLicenseDetails);
		}
		else {
			throw new ResourceNotFoundException("No Driver License Details found with id: "+driverLicenseDetails.getId());			
		}
	}

	@Override
	public DriverLicenseDetails getDriverLicenseDetails(Integer id) {
		
		return licenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Driver License Details found with id: "+id));
	}

	@Override
	public void deleteDriverLicenseDetails(Integer id) {
		
		Optional<DriverLicenseDetails> returnedOption = licenseRepository.findById(id);
		if (returnedOption.isPresent()) {
			licenseRepository.delete(returnedOption.get());
		}
		else {
			throw new ResourceNotFoundException("No Driver License Details found with id: "+id);			
		}
	}

	@Override
	public List<DriverLicenseDetails> getAllDriverLicenseDetails() {
		
		return licenseRepository.findAll();
	}

	@Override
	public DriverLicenseDetails getLicenseDetailsBySsn(String ssn) {

		
		Optional<DriverLicenseDetails> returnedOption = licenseRepository.findBySsn(ssn);
		if (returnedOption.isPresent()) {
			return returnedOption.get();
		}
		else {
			throw new ResourceNotFoundException("No Driver License Details found with SSN: "+ssn);			
		}
	}

	@Override
	public DriverLicenseDetails getLicenseDetailsByIssuedDate(LocalDate licenseIssuedDate) {
		
		Optional<DriverLicenseDetails> returnedOption = licenseRepository.findByLicenseIssuedDate(licenseIssuedDate);
		if (returnedOption.isPresent()) {
			return returnedOption.get();
		}
		else {
			throw new ResourceNotFoundException("No Driver License Details found with issued Date: "+licenseIssuedDate);			
		}
	}

	@Override
	public List<DriverLicenseDetails> getLicenseDetailsByIssuedState(String licenseIssuedState) {
		
		List<DriverLicenseDetails> licenseList = licenseRepository.findByLicenseIssuedState(licenseIssuedState);
		if (licenseList.isEmpty()) {
			throw new ResourceNotFoundException("No Driver License Details found with license issued State: "+licenseIssuedState);
		}
		return licenseList;
	}

	@Override
	public DriverLicenseDetails getLicenseDetailsByLicenseNumber(String licenseNumber) {

		Optional<DriverLicenseDetails> returnedOption = licenseRepository.findByLicenseNumber(licenseNumber);
		if (returnedOption.isPresent()) {
			return returnedOption.get();
		}
		else {
			throw new ResourceNotFoundException("No Driver License Details found with License number: "+licenseNumber);			
		}
	}

}
