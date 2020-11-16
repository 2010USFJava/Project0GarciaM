package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerAccount;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;
import com.revature.util.userInput.Login;

public class CustomerDaoImpl implements CustomerDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	BankAccountDao b = new BankAccountDaoImpl();	
		
	@Override
	public void createNewCustomer(String firstName, String lastName, String email, String password, String phone) throws SQLException {
			Connection conn = cf.getConnection();	
			String sql = "insert into customer values(default,default,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, phone);
			ps.executeUpdate();	
			LogThis.LogIt("info", "New Customer created and added to database for: " + firstName +" "+ lastName );
		
		
	}

	@Override
	public List<CustomerAccount> viewAccountsByID(int bank_id) throws SQLException {
		List<CustomerAccount> accountList = new ArrayList<CustomerAccount>();
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		String sql = "select * from customer where bank_ID=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bank_id);
		ResultSet rs = ps.executeQuery();
		//BankAccount a = null;
		while (rs.next()) {
		CustomerAccount	b = new CustomerAccount(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			accountList.add(b);
		}
		return accountList;
	}

	@Override
	public boolean customerLogin(String email, String password) throws SQLException {
		int cus1 = -1;
		int cus2 = -2;
		
		Connection conn = cf.getConnection();
		Statement stmt1 = conn.createStatement();
		
		String sql1 = "select user_id from customer where email =?";	
		PreparedStatement ps1 = conn.prepareCall(sql1);
		ps1.setString(1,email);
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next()) {
			cus1 = rs1.getInt(1);
			
		Statement stmt2 = conn.createStatement();
		String sql2 =  "select user_id from customer where userpassword =?";
		PreparedStatement ps2 = conn.prepareCall(sql2);
		ps2.setString(1,password);
		ResultSet rs2 = ps2.executeQuery();
		
		while(rs2.next()) {
			cus2 = rs2.getInt(1);
		}
		if (cus1 == cus2) {
			LogThis.LogIt("info", "Customer logged in number: " + cus1);
			Login.currentBankAccount = b.findBankAccountbyUserBank_ID(cus1);
			System.out.println("current account: " + Login.currentBankAccount);
			return true;
		}
		else
			return false;
	}
		return false;
	
	}

	@Override
	public List<CustomerAccount> viewAllAccounts() throws SQLException {
		List<CustomerAccount> accountList = new ArrayList<CustomerAccount>();
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		
		String sql = "select * from customer";
		PreparedStatement ps = conn.prepareCall(sql);
			
		ResultSet rs = ps.executeQuery();
		//BankAccount a = null;
		while (rs.next()) {
			CustomerAccount	b = new CustomerAccount(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			accountList.add(b);
		}
		return accountList;
		}
}

		


	


