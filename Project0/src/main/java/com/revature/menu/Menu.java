package com.revature.menu;

import java.util.Scanner;


import com.revature.util.LogThis;
import com.revature.service.TransacService;
import com.revature.service.TransactionMenu;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.Login;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	public static boolean login = false;
	
	public static void startMenu() {
		System.out.println("Welcome to the Best Bank Ever v2.0 app!");
		System.out.println();
		System.out.println("**********************************");
		System.out.println("\t Please enter a choice: ");
		System.out.println("\t [C]ustomer's portal");
		System.out.println("\t [E]mployee portal");
		System.out.println("\t [Q]uit the app");
		System.out.println("**********************************");
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()) {
			case "c":
				customerPortal();
				break;
			case "e":
				EmployeePortal.employeeMenu();
				break;
			case "q":
				System.out.println("Have a nice day!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input please try again");
				startMenu();
				break;
		
		}
	}
	
	public static void customerPortal() {
		System.out.println("Welcome Customer!");
		System.out.println("**********************************");
		System.out.println("\t[N]ew customer account");
		System.out.println("\t[L]ogin to access account");
		System.out.println("\t[B]back to previous menu");
		System.out.println("\t[Q]uit the application");
		System.out.println("**********************************");
		String choice = scan.nextLine();
		switch(choice.toLowerCase()) {
		case "n":
			GetInput.getCustomerInfo();
			customerPortal();
			break;
		case "l":
			
			if(Login.loginCustomer() == true) {
				
				TransactionMenu.transactionMenu();
				System.out.println("Login Sucessful!");
				login = true;
				System.out.println("Current account number: " + Login.currentBankAccount);
			}
			else {	System.out.println("Returning to menu\n");
				customerPortal();
			}
			
			break;
		case "b":
			startMenu();
		case "q":
			System.out.println("Have a nice day!");
			System.exit(0);
			break;			
		default:
			System.out.println("Invalid input please try again");
			customerPortal();
			break;
		
		
	}
		
}
	
		
}
		

	

