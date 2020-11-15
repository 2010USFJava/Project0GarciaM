package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

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
		Statement stmt1 = conn.createStatement();
		
		String sql1 = "select employeenumber from employee where email =?";	
		PreparedStatement ps1 = conn.prepareCall(sql1);
		ps1.setString(1,email);
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next()) {
			emp1 = rs1.getInt(1);
			
		Statement stmt2 = conn.createStatement();
		String sql2 =  "select employeenumber from employee where employeepassword =?";
		PreparedStatement ps2 = conn.prepareCall(sql2);
		ps2.setString(1,password);
		ResultSet rs2 = ps2.executeQuery();
		
		while(rs2.next()) {
			emp2 = rs2.getInt(1);
		}
		if (emp1 == emp2) {
			LogThis.LogIt("info", "Employee logged in number: " + emp1);
			return true;
		}
		else
			return false;
	}
		return false;
	
	}
}
