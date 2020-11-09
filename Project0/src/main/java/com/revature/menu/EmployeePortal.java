package com.revature.menu;

import java.util.Scanner;

import com.revature.service.TransacEmployee;
import com.revature.util.userInput.Login;

public class EmployeePortal {
	public static boolean login = false;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void employeeMenu(){
//			if (login == false) {
//				Login.loginEmployee();
//				login = true;
//			}
//			else {
				System.out.println("Welcome Employee");
				System.out.println("Choose frome below");
				System.out.println("\t [a]pprove or deny accounts");
				System.out.println("\t [v]iew customer accounts");
				System.out.println("\t [p]rint all bank accounts");
				System.out.println("\t [e]dit customer accounts");
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
					//edit here
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

	}
//}
	
