/**
 * 
 */
package com.springboot.mysql.empdep.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mysql.empdep.entity.Employee;

/**
 * @author sathyajeevan
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findByLastName(String lastName);
	List<Employee> findByBirthDate(Date birthDate);
}
