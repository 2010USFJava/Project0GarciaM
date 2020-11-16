package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDao {
	
	public void createBankAccount(double b) throws SQLException;
	
	public List<BankAccount> viewAccountsByID (int bankID) throws SQLException;
	
	public double viewBalance(int bankID) throws SQLException;
	
	public void updateBalance(double newBalance, int bankID) throws SQLException;
	
	public void depositAccount() throws SQLException;
	
	public void withdrawAccount() throws SQLException;

	public int findBankAccountbyUserBankID(int bankID) throws SQLException;
	
	public void deleteBankAccount(int bankID) throws SQLException;

}
