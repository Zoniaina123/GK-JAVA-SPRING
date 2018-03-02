package com.wha.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wha.spring.jdbc.model.Employee;

public class JDBCEmployeeDAOImpl implements CrudDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE " + "(ID, NAME, ROLE) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { employee.getId(), employee.getName(), employee.getRole() });
	}

	@SuppressWarnings("unchecked")
	public Employee getById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));

		return employee;
	}

	public List<Employee> getAll() {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> employees = new ArrayList<Employee>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			employee.setName((String) row.get("NAME"));
			employee.setRole((String) row.get("ROLE"));
			employees.add(employee);
		}
		return employees;
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
	}

}
