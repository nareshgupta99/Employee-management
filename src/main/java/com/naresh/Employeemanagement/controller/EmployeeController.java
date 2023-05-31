package com.naresh.Employeemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.Http11InputBuffer;
import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Employeemanagement.dto.EmployeeDto;
import com.naresh.Employeemanagement.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;

	@PostMapping("/employee")
	public void saveEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.addEmployee(employeeDto);
	}
	
	@GetMapping("/employee")
	public List<EmployeeDto> getAllEmployee(){
		List<EmployeeDto> employeeDto =employeeService.getEmployees();
		 return employeeDto;
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable int id){
		boolean flag=false;
		flag=employeeService.deleteEmployeeByid(id);
		Map map=new HashMap<>();
		map.put("status", flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	@PutMapping("/employee/{id}")
	public EmployeeDto editEmployee(@PathVariable int id,@RequestBody EmployeeDto employeeDto) {
		return employeeService.editEmployee(id, employeeDto);
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeDto getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
}
