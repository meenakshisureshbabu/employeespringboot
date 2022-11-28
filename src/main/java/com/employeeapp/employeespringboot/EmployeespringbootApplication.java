package com.employeeapp.employeespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.employeeapp.employeespringboot","com.employeeapp.employeespringboot.data"})
public class EmployeespringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeespringbootApplication.class, args);
	}

}
