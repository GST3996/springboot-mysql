package com.springboot.mysql.empdep.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mysql.empdep.entity.Employee;
import com.springboot.mysql.empdep.service.EmployeeService;

@RestController
@EnableAutoConfiguration
public class Employeecontroller {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/test")
	@ResponseBody
	String getMessage() {
		return "tetsing my service";
	}
	
	@GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer employeeId){
        return employeeService.getEmployee(employeeId);
        		}

    @PostMapping("/employees/create")
    public void addEmployee(@RequestBody Employee employee) {
    	employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) {
    	employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
    	employeeService.deleteEmployee(employeeId);
    }

}
