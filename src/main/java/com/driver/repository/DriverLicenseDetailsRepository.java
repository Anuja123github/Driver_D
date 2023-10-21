package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.DriverLicenseDetails;

@Repository
public interface DriverLicenseDetailsRepository extends JpaRepository<DriverLicenseDetails, Integer> {

}
