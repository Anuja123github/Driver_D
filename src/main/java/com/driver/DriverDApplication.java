package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.driver.repository")
@EnableEurekaClient
@EnableSwagger2
public class DriverDApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverDApplication.class, args);
	}

}
