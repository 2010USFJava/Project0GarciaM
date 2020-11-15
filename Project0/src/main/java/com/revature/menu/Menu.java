package com.revature.menu;

import java.util.Scanner;


import com.revature.util.LogThis;
import com.revature.service.TransacEmployee;
import com.revature.service.TransacService;
import com.revature.service.TransactionMenu;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.Login;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	public static boolean login = false;
	
	public static void startMenu() {
		System.out.println("Welcome to the Best Bank Ever app!");
		System.out.println("**********************************");
		System.out.println("Please enter a choice: ");
		System.out.println("\t [c]ustomer's portal");
		System.out.println("\t [e]mployee] portal");
		System.out.println("\t [q]uit the app");
		
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
		System.out.println("\t[n]ew customer account request");
		System.out.println("\t[l]ogin to access account");
		System.out.println("\t[b]back to previous menu");
		System.out.println("\t[q]uit the application");
		String choice = scan.nextLine();
		switch(choice.toLowerCase()) {
		case "n":
			GetInput.getCustomerInfo();
			customerPortal();
			break;
		case "l":
			
			if(Login.loginCustomer() == true) {
				TransactionMenu.transactionMenu();	
			}
			else {	System.out.println("Login Failed returning to menu or account not approved yet");
				LogThis.LogIt("info", "Customer login failed");
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
		

	

