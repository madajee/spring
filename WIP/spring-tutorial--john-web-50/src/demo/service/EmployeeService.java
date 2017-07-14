package demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import demo.model.Employee;
import demo.model.EmployeeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class EmployeeService implements EmployeeDAO{
	
	//private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	//@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public EmployeeService () {
		System.out.println("Successfully loaded employee servcie");
	}
	public void insert(Employee employee){
		final String sql = "insert into employees(userId,userName,userEmail,address) values(?,?,?,?)";
		//jdbcTemplate.update(sql, "12345","Tom", "tomea@mail.com", "USA");
		jdbcTemplate.update(sql, new Object[] { employee.getUserId(),employee.getUserName(), 
					employee.getUserEmail(), employee.getAddress()});
	}
	
	public List<Employee> findAll() {
		final String sql = "SELECT * FROM EMPLOYEES";
		List<Employee> employees = new ArrayList<Employee>();		
		/*List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for (Map row : rows) {
			Employee employee = new Employee();
			employee.setUserId(String.valueOf(row.get("userId")));
			employee.setUserName(String.valueOf(row.get("userName")));
			employee.setUserEmail(String.valueOf(row.get("userEmail")));
			employee.setAddress(String.valueOf(row.get("address")));
			employees.add(employee);

		}*/
		employees = jdbcTemplate.query(sql, 
                new EmployeeRowMapper());
		return employees;
	}

}
