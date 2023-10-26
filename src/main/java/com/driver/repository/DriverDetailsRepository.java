package com.driver.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.DriverDetails;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails,Integer>{

	public Optional<DriverDetails> findByPolicyId(Integer id);
            
	public List<DriverDetails> findByFirstname(String firstname);
			              
	public List<DriverDetails> findByLastname(String lastname);
	
	public List<DriverDetails> findByFirstnameAndLastname(String firstname, String lastname);
			              
	public Optional<DriverDetails> findByEmail(String email);
			              
	public Optional<DriverDetails> findByMobile(String mobile);
}
