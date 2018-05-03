package trng.imcs.firstmaven.mavenproject;

import lombok.Data;

@Data
public class Employee {

	private int empNo;
	private String fname;
	private String lname;
	private int age;
	private double salary;

	public Employee(int empNo, String fname, String lname, int age, double salary) {

		this.empNo = empNo;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.salary = salary;
	}
}
