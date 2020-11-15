package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDao {
	
	public void createBankAccount(double b) throws SQLException;
	
	public List<BankAccount> viewAccountsByID (int bank_ID) throws SQLException;
	
	public double viewBalance(int bank_ID) throws SQLException;
	
	public void updateBalance(double newBalance, int bank_ID) throws SQLException;
	
	public void deposit() throws SQLException;
	
	public void withdraw() throws SQLException;

}
