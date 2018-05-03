package trng.imcs.firstmaven.mavenproject;

import java.sql.SQLException;

public class EmployeeDAOApp {

	public static void main(String[] args) {

		EmployeeDAO empDao = new EmployeeDAO();

		// adding employees
		Employee emp1 = new Employee(1, "sid", "ram", 34, 56784);
		Employee emp2 = new Employee(2, "sam", "jon", 33, 55000);
		Employee emp3 = new Employee(3, "john", "sam", 30, 60000);

		/*
		 * try { empDao.addEmployee(emp1); empDao.addEmployee(emp2);
		 * empDao.addEmployee(emp3); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		/*
		 * try { empDao.deleteEmployee(2); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*try {
			empDao.updateEmployee(new Employee(1, "jon", "snow", 37, 5674));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			empDao.getEmployeeByName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
