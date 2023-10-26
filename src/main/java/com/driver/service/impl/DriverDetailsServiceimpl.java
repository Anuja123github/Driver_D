package com.driver.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.exception.ResourceNotFoundException;
import com.driver.model.DriverDetails;
import com.driver.repository.DriverDetailsRepository;
import com.driver.service.DriverDetailsService;

@Service
public class DriverDetailsServiceimpl implements DriverDetailsService {
//inject repository
	@Autowired
	private DriverDetailsRepository driverRepository;

	@Override
	public DriverDetails saveDriverDetails(DriverDetails driverDetails) {
		
		DriverDetails driverDetails1 = driverRepository.save(driverDetails);
		return driverDetails1;
	}

	@Override
	public DriverDetails getDriverDetails(Integer id) {
		
		Optional<DriverDetails> returnedDetail = driverRepository.findById(id);
		if (returnedDetail.isPresent()) {
			return returnedDetail.get();
		} else {
			throw new ResourceNotFoundException("No Driver detail found with id: " + id);
		}
	}

	@Override
	public DriverDetails updateDriverDetails(DriverDetails driverDetails) {
		
		Optional<DriverDetails> returnedDetail = driverRepository.findById(driverDetails.getId());
		if (returnedDetail.isPresent()) {
			return driverRepository.save(driverDetails);
		} else {
			throw new ResourceNotFoundException("No Driver detail found with id: " + driverDetails.getId());
		}
	}

	@Override
	public void deleteDriverDetails(Integer id) {
		
		Optional<DriverDetails> returnedDetail = driverRepository.findById(id);
		if (returnedDetail.isPresent()) {
			driverRepository.delete(returnedDetail.get());
		} else {
			throw new ResourceNotFoundException("No Driver detail found with id: " + id);
		}

	}

	@Override
	public DriverDetails getByPolicyId(Integer policyId) {
		
		Optional<DriverDetails> returnedDetail = driverRepository.findByPolicyId(policyId);
		if (returnedDetail.isPresent()) {
			return returnedDetail.get();
		} else {
			throw new ResourceNotFoundException("No Driver detail found with Policy Id: " + policyId);
		}
	}

	@Override
	public List<DriverDetails> getByFirstname(String firstname) {
		
		List<DriverDetails> list = driverRepository.findByFirstname(firstname);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("No Driver detail found with firstname: " + firstname);
		} else {
			return list;
		}
	}

	@Override
	public List<DriverDetails> getByLastname(String lastname) {
		
		List<DriverDetails> list = driverRepository.findByLastname(lastname);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("No Driver detail found with firstname: " + lastname);
		} else {
			return list;
		}
	}

	@Override
	public List<DriverDetails> getByFirstnameAndLastname(String firstname, String lastname) {
		
		List<DriverDetails> list = driverRepository.findByFirstnameAndLastname(firstname, lastname);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("No Driver detail found with firstname: " + firstname + " and lastname: " + lastname);
		} else {
			return list;
		}
	}

	@Override
	public DriverDetails getByEmail(String email) {
		Optional<DriverDetails> returnedDetail = driverRepository.findByEmail(email);
		if (returnedDetail.isPresent()) {
			return returnedDetail.get();
		} else {
			throw new ResourceNotFoundException("No Driver detail found with email: " + email);
		}
	}

	@Override
	public DriverDetails getByMobile(String mobile) {
		Optional<DriverDetails> returnedDetail = driverRepository.findByMobile(mobile);
		if (returnedDetail.isPresent()) {
			return returnedDetail.get();
		} else {
			throw new ResourceNotFoundException("No Driver detail found with mobile number: " + mobile);
		}
	}

}
