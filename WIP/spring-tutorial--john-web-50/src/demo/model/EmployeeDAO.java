package demo.model;
import java.util.List;

import javax.sql.DataSource;

public interface EmployeeDAO {
	public void insert(Employee employee);
	public List<Employee> findAll();
	public void  setDataSource(DataSource ds);
}
