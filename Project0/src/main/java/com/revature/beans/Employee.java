package com.revature.beans;

import com.revature.util.LogThis;

public class Employee {
	
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	
	public Employee() {
		super();
		LogThis.LogIt("info", "Empty employee created");
	}
	
	public Employee(int empNumber, String lastName, String firstName, String email, String password) {
		super();
		this.employeeNumber = empNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		
		LogThis.LogIt("info", "New account created for employee: " + firstName +" "+ lastName);
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", password=" + password + "]";
	}

	
}
