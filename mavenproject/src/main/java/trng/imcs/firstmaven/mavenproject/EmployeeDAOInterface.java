package trng.imcs.firstmaven.mavenproject;

import java.sql.SQLException;

public interface EmployeeDAOInterface {

	public boolean addEmployee(Employee emp) throws SQLException;

	public Employee getEmployee(int empId) throws SQLException;

	public boolean updateEmployee(Employee emp) throws SQLException;

	public boolean deleteEmployee(int empId) throws SQLException;

	public Employee displayAllInfo() throws SQLException;

	public void getEmployeeByName() throws SQLException;
}
