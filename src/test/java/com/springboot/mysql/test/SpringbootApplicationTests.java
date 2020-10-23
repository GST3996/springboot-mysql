package com.springboot.mysql.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.springboot.mysql.empdep.entity.Employee;
import com.springboot.mysql.empdep.entity.Gender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

public class SpringbootApplicationTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getEmployeeListTest() throws Exception {
		String uri = "/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Employee[] empList = super.mapFromJson(content, Employee[].class);
		assertTrue(empList.length > 0);
	}

	@Test
	public void createEmployeeTest() throws Exception {
		String uri = "/employees/create";
		Employee employee = new Employee();
		employee.setFirstName("SARAVANA");
		employee.setLastName("KUMAR");
		employee.setHireDate(new Date());
		employee.setBirthDate(new Date());
		employee.setGender(Gender.M);
		String inputJson = super.mapToJson(employee);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}
	
	@Test
	public void updateEmployeeTest() throws Exception{
		String uri = "/employees/10012";
		Employee employee = new Employee();
		employee.setEmpNo(10012);
		employee.setFirstName("SARAVANA");
		employee.setLastName("KUMAR KS");
		employee.setHireDate(new Date());
		employee.setBirthDate(new Date());
		employee.setGender(Gender.M);
		String inputJson = super.mapToJson(employee);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		
	}
}
