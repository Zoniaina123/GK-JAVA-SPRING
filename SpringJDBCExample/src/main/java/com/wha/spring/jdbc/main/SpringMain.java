package com.wha.spring.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wha.spring.jdbc.dao.CrudDAO;
import com.wha.spring.jdbc.model.Employee;

public class SpringMain {

	public static void main(String[] args) {
		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Get the EmployeeDAO Bean
		//CrudDAO employeeDAO = ctx.getBean("employeeDAO", CrudDAO.class);
		CrudDAO employeeDAO = ctx.getBean("jdbcEmployeeDAO", CrudDAO.class);
		// Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("wajih");
		emp.setRole("Java");

		// Create
		employeeDAO.save(emp);
		
		List<Employee> empls = employeeDAO.getAll();
		for (Employee employee : empls) {
			System.out.println(employee.getName());
		}
		
//		// Read
//		Employee emp1 = employeeDAO.getById(rand);
//		System.out.println("Employee Retrieved::" + emp1);
//		// Update
//		emp.setRole("CEO");
//		employeeDAO.update(emp);
//		// Get All
//		List<Employee> empList = employeeDAO.getAll();
//		System.out.println(empList);
//		// Delete
//		employeeDAO.deleteById(rand);
//		System.out.println("DONE");
//
       
        // Close Spring Context
		ctx.close();
	}

}
