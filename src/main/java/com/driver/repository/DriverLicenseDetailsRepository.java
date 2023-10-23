package com.driver.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.DriverLicenseDetails;

@Repository
public interface DriverLicenseDetailsRepository extends JpaRepository<DriverLicenseDetails, Integer> {

	public Optional<DriverLicenseDetails> findBySsn(String ssn);
	
	public Optional<DriverLicenseDetails> findByLicenseIssuedDate(LocalDate licenseIssuedDate);
	
	public List<DriverLicenseDetails> findByLicenseIssuedState(String licenseIssuedState);
	
	public Optional<DriverLicenseDetails> findByLicenseNumber(String licenseNumber);
}
