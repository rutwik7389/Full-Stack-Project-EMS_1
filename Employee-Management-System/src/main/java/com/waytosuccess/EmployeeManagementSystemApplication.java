package com.waytosuccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan(basePackages = "com.waytosuccess.entity")  
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}
