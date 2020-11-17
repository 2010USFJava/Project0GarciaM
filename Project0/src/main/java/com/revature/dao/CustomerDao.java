package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;



public interface CustomerDao {
	
	//create customer
	public void createNewCustomer(String firstName, String lastName, String email, String password, String phone) throws SQLException;

	public List<CustomerAccount> viewAllAccounts() throws SQLException;
	
	public CustomerAccount getAccountByID(int bankID)  throws SQLException;
	
	public boolean customerLogin(String email, String password) throws SQLException;
	
	public void deleteCustomer(int bankID) throws SQLException;
	
	public void editCustomer() throws SQLException;
 }
