package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.util.AccountList;
import com.revature.util.JointAccount;
import com.revature.util.LogThis;
import com.revature.util.UserAccount;
import com.revature.service.Transaction;
import com.revature.util.JointAccount;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to our Banking app!");
		System.out.println("Please enter a choice: ");
		System.out.println("\t [c]reate a new User Account");
		System.out.println("\t [l]ogin to an existing Account");
		System.out.println("\t [q]uit the app");
		
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()) {
			case "c":
				createMenu();
				break;
			case "l":
				loginMenu();
				break;
			case "q":
				System.out.println("Have a nice day!");
				break;
				default:
					System.out.println("Invalid input please try again");
					startMenu();
					break;
		
		}
	}
	
	public static void createMenu() {
		boolean isEmployee;
		System.out.println("Create a new user");
		System.out.println("Please enter a email for your account: ");
		String userEmail = scan.nextLine();
		System.out.println("Please enter your password for your account: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Please enter your Address: ");
		String address = scan.nextLine();
		System.out.println("Please enter your phone number for your account: ");
		String phone = scan.nextLine();
		System.out.println();
		System.out.println("Is this an employee account? (y/n)");
		String isEMP = scan.nextLine();
		if (isEMP.equalsIgnoreCase("y"))
			isEmployee = true;
		else
			isEmployee = false;
		System.out.println("Will this be a joint account? (y/n)");
		String jAccount = scan.nextLine();
	
		if (jAccount.equalsIgnoreCase("y")) {
//			JointAccount b = new JointAccount("Jack");
		}
		else {
			UserAccount a = new UserAccount(userEmail,password,name,address,phone, isEmployee);
		LogThis.LogIt("info",a.getUserName() + " account was created!");
		System.out.println(AccountList.userList.toString());
		}
		
		System.out.println("Would you like to make a new account? (y/n)");
		String choice = scan.nextLine();
		if(choice.equalsIgnoreCase("y"))
			createMenu();
		
		else if (choice.equalsIgnoreCase("n")) {
			startMenu();
		}
		else {
			System.out.println("You are going back to the main menu");
			startMenu();
			
	}
	}
	
	public static void loginMenu(){
		System.out.println("Enter the email address on account");
		String email = scan.nextLine();
		UserAccount a = AccountList.findAccountByEmail(email);
		System.out.println("Enter your password");
		String password = scan.nextLine();
		UserAccount b = AccountList.findAccountByPassword(password);
		
		if(a.equals(b)) {
			System.out.println("Login Successful!");
			LogThis.LogIt("info", "Login Successful for " + a.getUserEmail());
		}
		else {
			System.out.println("Login Failed");
			LogThis.LogIt("info", "Login Failed for " + a.getUserEmail());
		}
		
		
		startMenu();
				
		
		
	}
	
}
