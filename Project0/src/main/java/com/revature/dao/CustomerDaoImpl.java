package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.service.TransacService;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;
import com.revature.util.userInput.Login;

public class CustomerDaoImpl implements CustomerDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	static BankAccountDao b = new BankAccountDaoImpl();
	static CustomerDao c = new CustomerDaoImpl();
		
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
	public CustomerAccount getAccountByID(int bankid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customer where bank_ID=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bankid);
		ResultSet rs = ps.executeQuery();
		CustomerAccount	acc = null;
		while (rs.next()) {
		acc = new CustomerAccount(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		}
		return acc;
	}

	@Override
	public boolean customerLogin(String email, String password) throws SQLException {
		int cus1 = -1;
		int cus2 = -2;
		
		Connection conn = cf.getConnection();
		Statement stmt1 = conn.createStatement();
		
		String sql = "select user_id from customer where email =?";	
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		cus1 = rs.getInt(1);
			
		Statement stmt = conn.createStatement();
		sql =  "select user_id from customer where userpassword =?";
		ps = conn.prepareCall(sql);
		ps.setString(1,password);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			cus2 = rs.getInt(1);
		}
		if (cus1 == cus2) {
			LogThis.LogIt("info", "Customer logged in number: " + cus1);
			Login.currentBankAccount = b.findBankAccountbyUserBankID(cus1);
			System.out.println("current account: " + Login.currentBankAccount);
			Login.currentCustomer = cus1;
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

	@Override
	public void deleteCustomer(int bankID) throws SQLException {
		Connection conn = cf.getConnection();	
		String sql = "delete from customer where bank_id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, bankID);
		ps.executeUpdate();	
		LogThis.LogIt("info", " Customer deleted from database for account number: " + bankID );
		
	}

	
	
	@Override
	public void editCustomer() throws SQLException {
		Connection conn = cf.getConnection();	
		String sql = "update customer set firstname=?, lastname=?, email=?, userpassword=?, phone=? where bank_id =? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int account = TransacService.getAccount();
		Login.currentBankAccount = account;
		TransacService.changeCustomer(getAccountByID(account));
		//  goes back into database changed object
		CustomerAccount cus = TransacService.currentCustomer;
		System.out.println(cus);
		
	
		ps.setString(1, cus.getUserFirstName());
		ps.setString(2, cus.getUserLastName());
		ps.setString(3, cus.getUserEmail());
		ps.setString(4, cus.getUserPassword());
		ps.setString(5, cus.getUserPhone());
		ps.setInt(6, account);
		ps.executeUpdate();
	}
}

		


	


