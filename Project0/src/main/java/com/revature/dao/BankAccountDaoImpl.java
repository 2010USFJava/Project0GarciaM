package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.service.TransacService;
import com.revature.util.ConnFactory;
import com.revature.util.userInput.Login;

public class BankAccountDaoImpl implements BankAccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	public static Scanner scan = new Scanner(System.in);
	
	@Override
	public void createBankAccount(double initialDeposit) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into bankaccount values(default,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, initialDeposit);
		ps.setInt(2, 0);
		ps.setString(3, "Checking");
		ps.executeUpdate();
	}
	
	@Override
	public List<BankAccount> viewAccountsByID(int bank_id) throws SQLException {
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		String sql = "select * from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bank_id);
		ResultSet rs = ps.executeQuery();
		//BankAccount a = null;
		while (rs.next()) {
		BankAccount	b = new BankAccount(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getString(4));
			accountList.add(b);
		}
		return accountList;
	}

	@Override
	public double viewBalance(int bank_ID) throws SQLException {
		double balance = 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select accountbalance from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bank_ID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			balance = rs.getDouble(1);
		}
		
		return balance;
	}

	@Override
	public void updateBalance(double newBalance, int bank_ID) throws SQLException {
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		String sql = "update bankaccount set accountbalance=? where bank_account_id=? ";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setDouble(1, newBalance);
		ps.setInt(2, bank_ID);
		ps.executeUpdate();
		
	}

	@Override
	public void depositAccount() throws SQLException {
		System.out.println("Current balance $" + viewBalance(Login.currentBankAccount));
		System.out.println("How much would you like to deposit? ");
		double amount = Double.parseDouble(scan.nextLine());
		double newBalance = TransacService.deposit(amount);
		updateBalance(newBalance,Login.currentBankAccount);
			
		
	}
	
	@Override
	public void withdrawAccount() throws SQLException {
		System.out.println("Current balance" + viewBalance(Login.currentBankAccount));
		System.out.println("How much would you like to withdraw? ");
		double amount = Double.parseDouble(scan.nextLine());
		double newBalance = TransacService.withdraw(amount);
		updateBalance(newBalance,Login.currentBankAccount);

}

	@Override
	public int findBankAccountbyUserBank_ID(int bank_ID) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select bank_account_id from bankaccount where bank_account_ID=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bank_ID);
		ResultSet rs = ps.executeQuery();
		int bankAccountNum = -1;
		while (rs.next()) {
			bankAccountNum = rs.getInt(1);
		}
		return bankAccountNum;
	}

}