package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.util.userInput.Login;

public class TransacService {
	
	static BankAccountDao b = new BankAccountDaoImpl();
	static CustomerDao c = new CustomerDaoImpl();
	
	static Scanner scan = new Scanner(System.in);
	public static void checkBalance() {
		System.out.println("The balance of you account is: $");
		//System.out.println(GetInput.currentBankAccount.getAccountBalance());
	}
	
	public static double withdraw(double amount) {
		double balance = -1;
		
		try {
			balance = b.viewBalance(Login.currentBankAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double newBalance = balance - amount;
		return newBalance;
	}
	
	
	
	public static double deposit(double amount) {
		double balance = -1;
		try {
			balance = b.viewBalance(Login.currentBankAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double newBalance = balance + amount;
		return newBalance;
		
	}
	
	public static void deleteBothAccounts(int bankID){
		try {
			c.deleteCustomer(bankID);
			b.deleteBankAccount(bankID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getAccount() {
		System.out.println("Which account would you like to choose");
		int choice = Integer.parseInt(scan.nextLine());
		Login.currentBankAccount = choice;
		return  choice;
	}
		
	
	public static void printBalance() {
		System.out.println("Current balance is: ");
		//System.out.println("$"+GetInput.currentBankAccount.getAccountBalance());
	}
	
	
	
	
}