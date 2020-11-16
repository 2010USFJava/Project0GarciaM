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
import com.revature.util.LogThis;
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
		LogThis.LogIt("info", "New Account created and added to database initial deposit: $" + initialDeposit);
	}
	
	@Override
	public List<BankAccount> viewAccountsByID(int bankID) throws SQLException {
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		String sql = "select * from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bankID);
		ResultSet rs = ps.executeQuery();
		//BankAccount a = null;
		while (rs.next()) {
		BankAccount	b = new BankAccount(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getString(4));
			accountList.add(b);
		}
		return accountList;
	}

	@Override
	public double viewBalance(int bankID) throws SQLException {
		double balance = 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select accountbalance from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bankID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			balance = rs.getDouble(1);
		}
		
		return balance;
	}

	@Override
	public void updateBalance(double newBalance, int bankID) throws SQLException {
		Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		String sql = "update bankaccount set accountbalance=? where bank_account_id=? ";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setDouble(1, newBalance);
		ps.setInt(2, bankID);
		ps.executeUpdate();
		
	}

	@Override
	public void depositAccount() throws SQLException {
		System.out.println("Current balance: $" + viewBalance(Login.currentBankAccount));
		
		System.out.println("How much would you like to deposit? ");
		double amount = Double.parseDouble(scan.nextLine());
		
		double newBalance = TransacService.deposit(amount);
		updateBalance(newBalance,Login.currentBankAccount);
		LogThis.LogIt("info", "Account " + Login.currentBankAccount +" has deposited $" + amount +" from their account");
			
		
	}
	
	@Override
	public void withdrawAccount() throws SQLException {
		System.out.println("Current balance: $" + viewBalance(Login.currentBankAccount));
		double amount = 0;
		double newBalance = 0;
		
		while (newBalance <= 0) {
			do {
				if (amount < 0 || newBalance < 0)
					System.out.println("Invalid input or account will overdraw please try again");
				System.out.println("How much would you like to withdraw? ");
				 amount = Double.parseDouble(scan.nextLine());
			} while (amount < 0);
			newBalance = TransacService.withdraw(amount);
		}
		
		updateBalance(newBalance,Login.currentBankAccount);
		LogThis.LogIt("info", "Account " + Login.currentBankAccount +" has withdrawn $" + amount +" from their account");

}

	@Override
	public int findBankAccountbyUserBankID(int bankID) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select bank_account_id from bankaccount where bank_account_ID=?";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,bankID);
		ResultSet rs = ps.executeQuery();
		int bankAccountNum = -1;
		while (rs.next()) {
			bankAccountNum = rs.getInt(1);
		}
		return bankAccountNum;
	}
	
	public void deleteBankAccount(int bankID) throws SQLException{
		Connection conn = cf.getConnection();	
		String sql = "delete from bankaccount where bank_account_id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, bankID);
		ps.executeUpdate();
		LogThis.LogIt("info", " Bank Account deleted from database for account number: " + bankID );
	}

}