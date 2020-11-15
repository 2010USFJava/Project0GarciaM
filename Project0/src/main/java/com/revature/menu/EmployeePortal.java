package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.CustomerAccount;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.service.TransacEmployee;
import com.revature.service.TransacService;
import com.revature.service.TransactionMenu;
import com.revature.util.CustomerList;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.Login;

public class EmployeePortal {
	public static EmployeeDao emp = new EmployeeDaoImpl();
	
	public static boolean login = false;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void employeeMenu(){

				System.out.println("Welcome Employee");
				System.out.println("**********************************");
				System.out.println("Choose from below");
				System.out.println("[C]reate employee account");
				System.out.println("[L]ogin employee account");
				System.out.println("[B]ack to main menu");
				System.out.println("[Q]uit the app");
				
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
							AdminMenu();
						}
						else
							employeeMenu();
					
					break;
				case "b":
					login = false;
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
		System.out.println("What would you like to do ADMIN?");
		System.out.println("\t [D]ELETE an account");
		System.out.println("\t [E]DIT an account");
		System.out.println("\t [B]ack to previous menu");
		System.out.println("\t [Q]uit application");
		String choice = scan.nextLine();
		
		switch (choice.toLowerCase()) {
			case "d":
				TransacEmployee.deleteAccount();
				AdminMenu();	
			break;
			case "e":
				TransactionMenu.transactionMenu();
				AdminMenu();
			case "b":
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
	
