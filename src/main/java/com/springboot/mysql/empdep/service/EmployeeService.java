package com.springboot.mysql.empdep.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mysql.empdep.entity.Employee;
import com.springboot.mysql.empdep.repository.EmployeeRepository;
import com.springboot.mysql.empdep.repository.EmployeeRepositoryImpl;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeRepositoryImpl employeeRepositoryImpl;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public Employee getEmployee(Integer id) {
		return employeeRepository.findById(id).orElseGet(Employee::new);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void updateEmployee(Integer id, Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> searchEmployees(String lastName, String gender, Date dob){
		return employeeRepositoryImpl.getEmployeebyLastNameGenderDOB(lastName, gender, dob);
	}

}
