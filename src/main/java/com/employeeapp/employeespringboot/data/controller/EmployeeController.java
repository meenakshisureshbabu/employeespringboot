package com.employeeapp.employeespringboot.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapp.employeespringboot.data.models.Employee;
import com.employeeapp.employeespringboot.data.payload.EmployeeRequest;
import com.employeeapp.employeespringboot.data.payload.EmployeeResponse;
import com.employeeapp.employeespringboot.data.payload.MessageResponse;
import com.employeeapp.employeespringboot.data.service.EmployeeService;
import com.employeeapp.employeespringboot.data.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeservice.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> updateEmployee(@RequestBody EmployeeRequest employee){
		MessageResponse updEmployee = employeeservice.updateEmployee(employee);
        return new ResponseEntity<>(updEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<MessageResponse> deleteEmployee(@RequestParam int empid){
		MessageResponse delEmployee = employeeservice.deleteEmployee(empid);
		return new ResponseEntity<>(delEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<EmployeeResponse>> viewAllEmployees(){
		List<EmployeeResponse> emplist = employeeservice.fetchAllEmployees();
		return new ResponseEntity<>(emplist,HttpStatus.OK);
	}
	
	

}
