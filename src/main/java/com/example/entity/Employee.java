package com.example.entity;

import com.example.request.CreateEmployeeRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
	@Column(name="name")
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;

	@Column(name="salary")
	private int salary;
	
	public Employee(CreateEmployeeRequest emp) {
		this.name=emp.getName();
		this.empId=emp.getEmpId();
		this.salary=emp.getSalary();
	}
}
