package com.springboot.mysql.empdep.repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.mysql.empdep.entity.Employee;
import com.springboot.mysql.empdep.entity.Gender;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> getEmployeebyLastNameGenderDOB(String lastName, String gender, Date dob) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	 
	    Root<Employee> emp = cq.from(Employee.class);
	    List<Predicate> predicates = new ArrayList<>();
	    
	    if ( lastName!="" && lastName != null) {
	        predicates.add(cb.like(emp.get("lastName"), "%" + lastName + "%"));
	    }
	    if ( gender!="" && gender != null) {
	        predicates.add(cb.equal(emp.get("gender"), Gender.valueOf(gender)));
	    }
	    if (dob != null) {
	        predicates.add(cb.equal(emp.get("birthDate"), dob));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	    
	    return entityManager.createQuery(cq).getResultList();
	}

	
}
