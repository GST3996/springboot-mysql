package com.springboot.mysql.empdep.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mysql.empdep.entity.Employee;
import com.springboot.mysql.empdep.exception.EmployeeNotFoundException;
import com.springboot.mysql.empdep.service.EmployeeService;

@RestController
@EnableAutoConfiguration
public class Employeecontroller {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		ResponseEntity<Employee> emp =   new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
		Employee employee =  emp.getBody();
		if(employee.getEmpNo()==0) {
			throw new EmployeeNotFoundException("id-" + id+" not found");
		}
		return emp;
	}

	@PostMapping("/employees/create")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		ResponseEntity<Employee> emp =   new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
		Employee employeefromDB =  emp.getBody();
		if(employeefromDB.getEmpNo()==0) {
			throw new EmployeeNotFoundException("id-" + id+" not found");
		}
		employee.setEmpNo(id);
		employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

}
