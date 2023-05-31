package com.naresh.Employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naresh.Employeemanagement.model.Employee;

public interface EmplooyeeRepo extends JpaRepository<Employee, Integer> {

}
