package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.CustomerAccount;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.service.TransacService;
import com.revature.service.TransactionMenu;
import com.revature.util.LogThis;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.Login;

public class EmployeePortal {
	public static EmployeeDao emp = new EmployeeDaoImpl();
	
	public static boolean login = false;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void employeeMenu(){

				System.out.println("Welcome Employee");
				System.out.println("**********************************");
				System.out.println("\tChoose from below");
				System.out.println("\t[C]reate employee account");
				System.out.println("\t[L]ogin employee account");
				System.out.println("\t[B]ack to main menu");
				System.out.println("\t[Q]uit the app");
				System.out.println("**********************************");
				String choice = scan.nextLine();
				
				switch(choice.toLowerCase()) {
				case "c":
					GetInput.getEmployeeInput();
					employeeMenu();
					break;
				case "l":
					if (login == false)
						if(Login.employeeLogin()) {
							System.out.println("Login Sucessful");
							login = true;
							AdminMenu();
						}
						else
							employeeMenu();
					
					break;
				case "b":
					Menu.startMenu();
					break;
				case "q":
					System.out.println("Goodbye");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input returning to menu");
					employeeMenu();
				}
	}

	public static void chooseAccount() {
		
	}

	
	
	public static void AdminMenu() {
		chooseAccount();
		System.out.println("What would you like to do Admin?");
		System.out.println("**********************************");
		System.out.println("\t [D]elete an account");
		System.out.println("\t [M]anage user information");
		System.out.println("\t [C]hange bank account info");
		System.out.println("\t [E]dit a balance for an account");
		System.out.println("\t [B]ack to previous menu");
		System.out.println("\t [Q]uit application");
		System.out.println("**********************************");
		String choice = scan.nextLine();
		
		switch (choice.toLowerCase()) {
			case "d":
				TransacService.deleteBothAccounts(TransacService.getAccount());
				AdminMenu();	
			break;
			case "e":
				TransacService.getAccount();
				TransactionMenu.transactionMenu();
				AdminMenu();
			case "b":
				login = false;
				System.out.println("You have been logged out");
				LogThis.LogIt("info", "Employee has been logged out numer: " + Login.currentEmployee);
				Login.currentEmployee = 0;
				employeeMenu();
				break;
			case "q":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input returning to edit menu");
				AdminMenu();
				break;
		}
		
		
		employeeMenu();
	}
}
	
