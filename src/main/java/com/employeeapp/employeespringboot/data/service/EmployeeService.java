package com.employeeapp.employeespringboot.data.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employeeapp.employeespringboot.data.models.Employee;
import com.employeeapp.employeespringboot.data.payload.EmployeeRequest;
import com.employeeapp.employeespringboot.data.payload.EmployeeResponse;
import com.employeeapp.employeespringboot.data.payload.MessageResponse;


public interface EmployeeService {
	
	MessageResponse createEmployee(EmployeeRequest employeerequest);
	MessageResponse updateEmployee(EmployeeRequest employeerequest);
	MessageResponse deleteEmployee(int empid);
	List<EmployeeResponse> fetchAllEmployees();

}
