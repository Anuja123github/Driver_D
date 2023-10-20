package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.driver.repository")
public class DriverDApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverDApplication.class, args);
	}

}
