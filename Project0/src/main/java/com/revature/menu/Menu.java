package com.revature.menu;

import java.util.Scanner;


import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;
import com.revature.service.Transaction;
import com.revature.util.userInput.GetInput;


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
		System.out.println("Create a new user");
		GetInput.UserAccountInput();
			
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
		GetInput.InputLogin();
		
		
		startMenu();
				
		
		
	}
	
}
