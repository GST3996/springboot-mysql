package com.springboot.mysql.empdep.repository;

import java.util.Date;
import java.util.List;

import com.springboot.mysql.empdep.entity.Employee;

public interface EmployeeRepositoryCustom {
	
	List<Employee> getEmployeebyLastNameGenderDOB(String lastName,String Gender,Date dob);

}
