package com.employeeapp.employeespringboot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.employeespringboot.data.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
