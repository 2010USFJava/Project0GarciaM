package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.CustomerAccount;
import com.revature.service.TransacEmployee;
import com.revature.service.TransacService;
import com.revature.service.TransactionMenu;
import com.revature.util.BankData;
import com.revature.util.CustomerList;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.Login;

public class EmployeePortal {
	public static boolean login = false;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void employeeMenu(){

				System.out.println("Welcome Employee");
				System.out.println("Choose frome below");
				System.out.println("\t [a]pprove or deny accounts");
				System.out.println("\t [v]iew customer accounts");
				System.out.println("\t [p]rint all bank accounts");
				System.out.println("\t [e]dit customer accounts: ADMINS ONLY");
				System.out.println("\t [b]ack to previous menu and logout");
				System.out.println("\t [q]uit the application");
				String choice = scan.nextLine();
				
				switch(choice.toLowerCase()) {
				case "a":
					TransacEmployee.approveAccounts();
					 employeeMenu();
					break;
				case "v":
					TransacEmployee.printCustomerAccounts();
					 employeeMenu();
					break;	
				case "p":
					TransacEmployee.printBankAccounts();
					 employeeMenu();
					break;
				case "e":
					editMenu();
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
		int choice = -1;
		System.out.println("Printing all  accounts");
		for (CustomerAccount lc: CustomerList.userList) { 
			System.out.println(lc);
		}
				
					System.out.println("Please choose which to edit by account number");
					choice = Integer.parseInt(scan.nextLine());
									
					System.out.println(BankData.findAccountByAccountNumber(choice));
					GetInput.currentBankAccount = BankData.findAccountByAccountNumber(choice);
					System.out.println(GetInput.currentBankAccount);
	}

	
	
	public static void editMenu() {
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
				editMenu();	
			break;
			case "e":
				TransactionMenu.transactionMenu();
				editMenu();
			case "b":
				employeeMenu();
				break;
			case "q":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input returning to edit menu");
				editMenu();
				break;
		}
		
		
		employeeMenu();
	}
}
	
