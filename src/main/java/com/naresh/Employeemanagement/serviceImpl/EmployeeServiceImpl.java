package com.naresh.Employeemanagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Employeemanagement.dto.EmployeeDto;
import com.naresh.Employeemanagement.model.Employee;
import com.naresh.Employeemanagement.repository.EmplooyeeRepo;
import com.naresh.Employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmplooyeeRepo emplooyeeRepo;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee=modelMapper.map(employeeDto, Employee.class);
		emplooyeeRepo.save(employee);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees= emplooyeeRepo.findAll();
		List<EmployeeDto> employeeDtos= employees.stream().map(emp->modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public boolean deleteEmployeeByid(int id) {
		Employee employee= emplooyeeRepo.findById(id).get();
		emplooyeeRepo.delete(employee);
		return true;
		
	}

	@Override
	public EmployeeDto editEmployee(int id,EmployeeDto employeeDto) {
		Employee employee= emplooyeeRepo.findById(id).get();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		emplooyeeRepo.save(employee);
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		Employee employe= emplooyeeRepo.findById(id).get();
		return modelMapper.map(employe, EmployeeDto.class);
	}
	
	
	
	
	

}
