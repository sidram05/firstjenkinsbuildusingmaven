package trng.imcs.firstmaven.mavenproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDAO implements EmployeeDAOInterface {

	Connection connection;
	{
		try {
			connection = createConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addEmployee(Employee emp) throws SQLException {
		if (emp == null)
			return false;
		PreparedStatement statement = connection.prepareStatement(
				"insert into employeedatabase.employee (empNo, fname, lname, age, salary) values (?, ?, ?, ?, ?) ");
		statement.setInt(1, emp.getEmpNo());
		statement.setString(2, emp.getFname());
		statement.setString(3, emp.getLname());
		statement.setInt(4, emp.getAge());
		statement.setDouble(5, emp.getSalary());

		return statement.executeUpdate() > 0;
	}

	public Employee getEmployee(int empId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(
				"select empNo, fname, lname, age, salary from employeedatabase.employee where empNo = ? ");
		statement.setInt(1, empId);
		ResultSet resultSet = statement.executeQuery();
		// use resultset
		if (resultSet.next()) {
			Employee emp = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getInt(4), resultSet.getDouble(5));
			return emp;
		}
		return null;
	}

	public boolean updateEmployee(Employee emp) throws SQLException {
		// db operations
		PreparedStatement statement = connection.prepareStatement(
				"update employeedatabase.employee set fname = ?, lname = ?, age = ?, salary = ? where empNo = ?");

		// check the balance is sufficient to deduct

		statement.setString(1, emp.getFname());
		statement.setString(2, emp.getLname());
		statement.setInt(3, emp.getAge());
		statement.setDouble(4, emp.getSalary());
		statement.setInt(5, emp.getEmpNo());

		return statement.executeUpdate() > 0;
	}

	public boolean deleteEmployee(int empId) throws SQLException {
		PreparedStatement statement = connection
				.prepareStatement("delete from employeedatabase.employee where empNo = ? ");
		statement.setInt(1, empId);
		return statement.executeUpdate() > 0;
	}

	public Employee displayAllInfo() throws SQLException {
		PreparedStatement statement = connection
				.prepareStatement("select empNo, fname, lname, age, salary from employeedatabase.employee");
		ResultSet resultSet = statement.executeQuery();
		// use resultset
		if (resultSet.next()) {
			Employee emp = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getInt(4), resultSet.getDouble(5));
			return emp;
		}
		return null;

	}
	
	public void getEmployeeByName() throws SQLException {
		PreparedStatement statement = connection.prepareStatement(
				"select empNo, fname, lname, age, salary from employeedatabase.employee order by fname asc");
		ResultSet resultSet = statement.executeQuery();
		// use resultset
		System.out.println("Employee Id" + " fname " + " lname "+ " age "+ " salary");
		
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+ " " + resultSet.getString(3)+ " " +
						resultSet.getInt(4)+ " " + resultSet.getDouble(5));
		}
		
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {

		Properties prop = new Properties();
		File file = new File(
				"C:\\Users\\sidda\\Desktop\\IMCS\\CoreJavaProj\\src\\trng\\JDBCandDatabase\\dbconfig.properties");
		try {
			FileInputStream fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// register driver
		Class.forName(prop.getProperty("DB_DRIVER"));

		// establish connection
		Connection connection = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("DB_USER"),
				prop.getProperty("DB_PWD"));

		return connection;
	}

}
