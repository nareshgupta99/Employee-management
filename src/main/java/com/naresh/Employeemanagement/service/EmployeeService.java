package com.naresh.Employeemanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.naresh.Employeemanagement.dto.EmployeeDto;

public interface EmployeeService {

	public void addEmployee(EmployeeDto employeeDto);
	
	public List< EmployeeDto> getEmployees();
	
	public boolean deleteEmployeeByid(int id);
	
	public EmployeeDto editEmployee(int id,EmployeeDto employeeDto);
	
	public EmployeeDto getEmployeeById(int id);
}
