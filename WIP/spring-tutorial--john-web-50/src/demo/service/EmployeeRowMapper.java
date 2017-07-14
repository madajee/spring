package demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import demo.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setUserId(String.valueOf(row.getString("userId")));
		employee.setUserName(String.valueOf(row.getString("userName")));
		employee.setUserEmail(String.valueOf(row.getString("userEmail")));
		employee.setAddress(String.valueOf(row.getString("address")));
		return employee;
	}

}
