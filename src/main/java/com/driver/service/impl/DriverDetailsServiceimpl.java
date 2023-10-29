package com.driver.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.driver.dto.DriverDetailsDto;
import com.driver.dto.PolicyDto;
import com.driver.exception.ResourceNotFoundException;
import com.driver.model.DriverDetails;
import com.driver.repository.DriverDetailsRepository;
import com.driver.service.DriverDetailsService;

@Service
public class DriverDetailsServiceimpl implements DriverDetailsService {
//inject repository
	@Autowired
	private DriverDetailsRepository driverRepository;

	@Autowired
	private WebClient webClient;

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
			throw new ResourceNotFoundException(
					"No Driver detail found with firstname: " + firstname + " and lastname: " + lastname);
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

	@Override
	public DriverDetailsDto getDriverPolicyDetails(Integer id) {
		
		Optional<DriverDetails> returnedDetail = driverRepository.findById(id);
		if (returnedDetail.isPresent()) {
			DriverDetailsDto detailsDto = mapToDriver(returnedDetail.get());
			PolicyDto policyDto = webClient.get().uri("http://localhost:8080/getPolicyById/" + returnedDetail.get().getPolicyId()).retrieve().bodyToMono(PolicyDto.class).block();
			detailsDto.setPolicy(policyDto);
			return detailsDto;
		} else {
			throw new ResourceNotFoundException("No Driver detail found with id: " + id);
		}
	}

	private DriverDetailsDto mapToDriver(DriverDetails driverDetails) {
		// get the value from user and set into userDto
		DriverDetailsDto detailsDto = new DriverDetailsDto();
		detailsDto.setId(driverDetails.getId());
		detailsDto.setFirstname(driverDetails.getFirstname());
		detailsDto.setLastname(driverDetails.getLastname());
		detailsDto.setDob(driverDetails.getDob());
		detailsDto.setEmail(driverDetails.getEmail());
		detailsDto.setMobile(driverDetails.getMobile());
		return detailsDto;
	}
}
