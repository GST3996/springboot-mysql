/**
 * 
 */
package com.springboot.mysql.empdep.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mysql.empdep.entity.Employee;

/**
 * @author sathyajeevan
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	
}
