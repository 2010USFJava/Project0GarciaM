package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.menu.EmployeePortal;
import com.revature.util.userInput.Login;

public class TransacService {
	
	public static CustomerAccount currentCustomer;
	public static BankAccount currentBankAccount;
	
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
				if (b.viewBalance(Login.currentBankAccount) > 0) {
					System.out.println("You must set balance to 0 before deleting account");
					EmployeePortal.AdminMenu();
				}
				else {
					c.deleteCustomer(bankID);
					b.deleteBankAccount(bankID);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
	
	public static int getAccount() {
		System.out.println("Which account would you like to choose");
		int edit = Integer.parseInt(scan.nextLine());
		Login.currentBankAccount = edit;
		return  edit;
	}
		
	
	public static void printBalance() {
		System.out.println("Current balance is: ");
		//System.out.println("$"+GetInput.currentBankAccount.getAccountBalance());
	}
	
	public static void changeBankAccount(BankAccount b) {
		String choice;
		System.out.println(b);
		do {
		System.out.println("**********************************");
		
		System.out.println("What would you like to change from bank account");
		System.out.println("\t [A]ccount Balance");
		System.out.println("\t [T]ransaction Count");
		System.out.println("\t [S]et account type");
		System.out.println("\t [R]egister changes ");
		System.out.println("\t [B]ack to previous menu");
		
		choice = scan.nextLine();
		
			String edit = "";
			switch (choice.toLowerCase()){
				case "a":
					System.out.println("What do you want to change the account balance to? ");
					edit = scan.nextLine();
					b.setAccountBalance(Double.parseDouble(edit));
					break;
				case "t":
					System.out.println("What do you want to set the transaction count to? ");
					edit = scan.nextLine();
					b.setTransactionCount(Integer.parseInt(edit));
					
					break;
				case "s":
					System.out.println("What type account would you like to set? ");
					edit = scan.nextLine();
					b.setAccountType(edit);
			
					break;
				case "b":
					
					EmployeePortal.AdminMenu();
					break;
				case "r":
					break;
				default:
					System.out.println("Invalid input returning to menu");
					EmployeePortal.AdminMenu();
					break;
				}
			
		}while (!choice.equals("r"));
		System.out.println(b);
		currentBankAccount = b;
	}
	
	
	public static void changeCustomer(CustomerAccount c) {
		String choice;
		System.out.println(c);
		do {
		System.out.println("**********************************");
		
		System.out.println("What would you like to change from customer");
		System.out.println("\t [L]ast Name");
		System.out.println("\t [F]irst Name");
		System.out.println("\t [E]mail");
		System.out.println("\t [P]assword");
		System.out.println("\t [C]hange Phone Number");
		System.out.println("\t [R]egister changes ");
		System.out.println("\t [B]ack to previous menu");
		
		choice = scan.nextLine();
		
			String edit = "";
			switch (choice.toLowerCase()){
				case "l":
					System.out.println("What do you want the last name to be? ");
					edit = scan.nextLine();
					c.setUserLastName(edit);
					break;
				case "f":
					System.out.println("What do you want the first name to be? ");
					edit = scan.nextLine();
					c.setUserFirstName(edit);
					
					break;
				case "e":
					System.out.println("What do you want the email to be? ");
					edit = scan.nextLine();
					c.setUserEmail(edit);
			
					break;
				case "p":
					System.out.println("What do you want the password to be? ");
					edit = scan.nextLine();
					c.setUserPassword(edit);
					
					break;
				case "c":
					System.out.println("What do you want the phone number to be? ");
					edit = scan.nextLine();
					c.setUserPhone(edit);
					
					break;
				case "b":
					
					EmployeePortal.AdminMenu();
					break;
				case "r":
					break;
				default:
					System.out.println("Invalid input returning to menu");
					EmployeePortal.AdminMenu();
					break;
				}
			
		}while (!choice.equals("r"));
		System.out.println(c);
		currentCustomer = c;
	}
		
	
}