package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;

import com.example.repository.EmployeeRepository;
import com.example.request.CreateEmployeeRequest;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	public Employee createEmployee(CreateEmployeeRequest create) {
		Employee emp=new Employee();
		emp.setName(create.getName());
		emp.setEmpId(create.getEmpId());
		emp.setSalary(create.getSalary());
		emp=employeeRepository.save(emp);
		return emp;
	}

}
