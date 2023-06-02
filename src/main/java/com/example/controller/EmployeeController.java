package com.example.controller;

import java.util.List;
import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;

import com.example.request.CreateEmployeeRequest;

import com.example.response.EmployeeResponse;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	@GetMapping("getAllEmployee")
	public List<EmployeeResponse> getEmployees(){
		List<Employee> empList=empService.getAllEmployee();
		List<EmployeeResponse> empResponseList=new ArrayList<EmployeeResponse>();
		empList.stream().forEach(employee->{
			empResponseList.add(new EmployeeResponse(employee));
		});
		return empResponseList;
	}
	@PostMapping("create")
	public EmployeeResponse createStudent(@Valid @RequestBody CreateEmployeeRequest create) {
		Employee emp=empService.createEmployee(create);
		
		return new EmployeeResponse(emp);
		
	}
}
