package com.employeeapp.employeespringboot.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeeapp.employeespringboot.data.models.DepartmentEntity;
import com.employeeapp.employeespringboot.data.models.Employee;
import com.employeeapp.employeespringboot.data.payload.EmployeeRequest;
import com.employeeapp.employeespringboot.data.payload.EmployeeResponse;
import com.employeeapp.employeespringboot.data.payload.MessageResponse;
import com.employeeapp.employeespringboot.data.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	public MessageResponse createEmployee(EmployeeRequest employeerequest) {
		// TODO Auto-generated method stub
		Employee newemp = new Employee();
		newemp.setFirstname(employeerequest.getFirstname());
		newemp.setLastname(employeerequest.getLastname());
		newemp.setDeptid(employeerequest.getDeptid());
		String url = "http://localhost:8081/departmentname/getDeptName?deptId="+employeerequest.getDeptid();
		DepartmentEntity departmententity;
		RestTemplate resttemplate = new RestTemplate();
		Gson gson = new Gson();
		String deptentity = resttemplate.getForObject(url, String.class);
		departmententity = gson.fromJson(deptentity, DepartmentEntity.class);
		newemp.setDeptname(departmententity.getDeptName());
		//System.out.println("Emp details before save "+newemp);
		employeerepository.save(newemp);
		return new MessageResponse("Employee successfully added");
		
		
	}

	@Override
	public MessageResponse updateEmployee(EmployeeRequest employeerequest) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		int empid = employeerequest.getId();
		
		emp.setFirstname(employeerequest.getFirstname());
		emp.setLastname(employeerequest.getLastname());
		emp.setDeptid(employeerequest.getDeptid());
		if(employeerepository.existsById(empid))
		{
			emp.setId(empid);
			employeerepository.save(emp);
			return new MessageResponse("EmpId updated");
		}
		else
		{
			return new MessageResponse("EmpId does not exists");
		}
		
		
		//return null;
	}

	@Override
	public MessageResponse deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		if(employeerepository.existsById(empid))
		{
			employeerepository.deleteById(empid);
			return new MessageResponse("Employee successfully deleted");
		}
		else
		{
			return new MessageResponse("Employee ID doesn't exist");
		}
	}

	@Override
	public List<EmployeeResponse> fetchAllEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> emplist =  employeerepository.findAll();
		List<EmployeeResponse> response = new ArrayList<>();
		for(Employee e:emplist) {
			EmployeeResponse empresponse = new EmployeeResponse();
			empresponse.setId(e.getId());
			empresponse.setFirstname(e.getFirstname());
			empresponse.setLastname(e.getLastname());
			empresponse.setDeptid(e.getDeptid());
			
			//Add 
			response.add(empresponse);
		}
		
		
		//System.out.println("LLLLLLLLLLLLLLLL"+emplist.get(1));
		return response;
		//return null;
	}
	
	

}
