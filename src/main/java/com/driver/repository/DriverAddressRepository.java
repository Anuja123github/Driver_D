package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.DriverAddress;

@Repository
public interface DriverAddressRepository extends JpaRepository<DriverAddress,Integer > {
	
	public DriverAddress findyByCity (String city);

}
