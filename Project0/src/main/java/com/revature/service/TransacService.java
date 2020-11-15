package com.revature.service;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.InputValidation;

public class TransacService {

	static Scanner scan = new Scanner(System.in);
	public static void checkBalance() {
		System.out.println("The balance of you account is: $");
		//System.out.println(GetInput.currentBankAccount.getAccountBalance());
	}
	
	public static void withdrawAccount() {
		printBalance();
		System.out.println("How much would you like to withdraw");
		double amount = Double.parseDouble(scan.nextLine());
		}
	
	
	
	public static double deposit(double amount) {
		//Get old balance
		double newBalance = 0;
		
		newBalance += amount;
		return newBalance;
	}
	
	public static void depositAccount() {
		printBalance();
		System.out.println("Enter the amount you would like to deposit" );
		double deposit =Double.parseDouble(scan.nextLine());
		
	}
	
	
		
	
	public static void printBalance() {
		System.out.println("Current balance is: ");
		//System.out.println("$"+GetInput.currentBankAccount.getAccountBalance());
	}
	
	
	
	
}