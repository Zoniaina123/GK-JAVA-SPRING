package com.wha.spring.jdbc.dao;

import java.util.List;

import com.wha.spring.jdbc.model.Employee;

public interface CrudDAO {
	// Create
	public void save(Employee employee);

	// Read
	public Employee getById(int id);

	// Update
	public void update(Employee employee);

	// Delete
	public void deleteById(int id);

	// Get All
	public List<Employee> getAll();
}
