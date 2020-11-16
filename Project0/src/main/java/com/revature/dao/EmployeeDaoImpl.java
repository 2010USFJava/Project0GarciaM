package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnFactory;
import com.revature.util.LogThis;
import com.revature.util.userInput.Login;

public class EmployeeDaoImpl implements EmployeeDao {
	ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createNewEmployee(String fName, String lName, String email, String password) throws SQLException {
		Connection conn = cf.getConnection();	
		String sql = "insert into employee values(default,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setString(3, email);
		ps.setString(4, password);
		LogThis.LogIt("info", "New Employee created and added to database for: " + fName +" "+ lName );
		ps.executeUpdate();	
		
	}

	@Override
	public boolean loginEmployee(String email ,String password) throws SQLException {
		int emp1 = -1;
		int emp2 = -2;
		
		Connection conn = cf.getConnection();
		
		String sql = "select employeenumber from employee where email =?";	
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			emp1 = rs.getInt(1);
			
		sql =  "select employeenumber from employee where employeepassword =?";
		ps = conn.prepareCall(sql);
		ps.setString(1,password);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			emp2 = rs.getInt(1);
		}
		if (emp1 == emp2) {
			LogThis.LogIt("info", "Employee logged in number: " + emp1);
			Login.currentEmployee = emp1;
			return true;
		}
		else
			return false;
	}
		return false;
	
	}

	
	
}
