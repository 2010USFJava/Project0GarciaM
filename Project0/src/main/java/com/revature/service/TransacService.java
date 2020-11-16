package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.util.LogThis;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.InputValidation;
import com.revature.util.userInput.Login;

public class TransacService {
	
	static BankAccountDao b = new BankAccountDaoImpl();
		
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
		System.out.println("Current Balance: "+ balance);
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
		System.out.println("Current Balance: "+ balance);
		double newBalance = balance + amount;
		return newBalance;
		
	}
	
	
		
	
	public static void printBalance() {
		System.out.println("Current balance is: ");
		//System.out.println("$"+GetInput.currentBankAccount.getAccountBalance());
	}
	
	
	
	
}