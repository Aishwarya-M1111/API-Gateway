package com.example.response;

import com.example.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {
	
	private String name;
	private int empId;
	private int salary;
	
	public EmployeeResponse(Employee emp) {
		this.name=emp.getName();
		this.empId=emp.getEmpId();
		this.salary=emp.getSalary();
	}
}
