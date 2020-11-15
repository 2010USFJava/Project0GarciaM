package com.revature.dao;

import java.sql.SQLException;

public interface EmployeeDao {
	
	public void createNewEmployee(String fName, String lName, String email, String password) throws SQLException;
	
	public boolean loginEmployee(String email ,String password) throws SQLException;

}
