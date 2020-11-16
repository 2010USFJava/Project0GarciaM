package com.revature.util.userInput;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.LogThis;


public class GetInput {
	
	static Scanner scan = new Scanner(System.in);

	public static void getCustomerInfo() {
		
		CustomerDao c = new CustomerDaoImpl();
		BankAccountDao b = new BankAccountDaoImpl();
		
		boolean valid = false;
		boolean validEmail = false;
		boolean validPhone = false;
		String userEmail;
		String phone;
		String fName;
		String lName;
		String password;
		double initialDeposit;
		
		do {
			System.out.println("Please enter a email for your account this will be your username: ");
			userEmail = scan.nextLine();
			if (userEmail.contains("@") && userEmail.contains(".") && !userEmail.contains(" "))
				validEmail = true;
			else {
				validEmail = false;
				System.out.println("Please enter a valid email");
			}
		} while(validEmail == false);
		
		do {
			
			System.out.println("Please enter your password for your account at least 8 characters no spaces: ");
			password = scan.nextLine();
			if (password.length() < 8 || password.contains(" ")) { 
				valid = false;
				System.out.println("Invalid input please try again");
			}
			else {
				valid = true;
			}
			
		} while (!valid);
		System.out.println("Please enter your first name: ");
		fName = scan.nextLine();
		
		System.out.println("Please enter your last name: ");
		lName = scan.nextLine();
		
		System.out.println();
		
		do {
			System.out.println("Please enter your phone number for your account: ");
			phone = scan.nextLine();
			if (phone.length() > 12 || phone.contains(" ") || phone.length() < 9) {
				validPhone = false;
				System.out.println("Please enter correct number of digits with no spaces");
			}
			else
				validPhone = true;
		} while (validPhone == false);
		
		System.out.println();
		
		do {
			System.out.println("Please enter your initial deposit");
			initialDeposit = Double.parseDouble(scan.nextLine());
			if (initialDeposit < 0)
				System.out.println("Invalid input please try again");
		} while (initialDeposit < 0);
		try {
			b.createBankAccount(initialDeposit);
			c.createNewCustomer(fName, lName, userEmail, password, phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void getEmployeeInput() {
		
		EmployeeDao emp = new EmployeeDaoImpl();
		boolean validEmail = false;
		String userEmail;
		String fName;
		String lName;
		String password;
		boolean valid;
		
		do {
			System.out.println("Please enter a email for your account this will be your username: ");
			userEmail = scan.nextLine();
			if (userEmail.contains("@") && userEmail.contains(".") && !userEmail.contains(" "))
				validEmail = true;
			else {
				validEmail = false;
				System.out.println("Please enter a valid email");
			}
		} while(validEmail == false);
		
		do {
			
			System.out.println("Please enter your password for your account at least 8 characters no spaces: ");
			password = scan.nextLine();
			if (password.length() < 8 || password.contains(" ")) { 
				valid = false;
				System.out.println("Invalid input please try again");
			}
			else {
				valid = true;
			}
		}
			while (!valid);
		
		System.out.println("Please enter your first name: ");
		fName = scan.nextLine();
		
		System.out.println("Please enter your last name: ");
		lName = scan.nextLine();
		
		System.out.println();
		
		try {
			emp.createNewEmployee(fName, lName, userEmail, password);
			LogThis.LogIt("info", "New employee created for: " + fName +" "+lName );	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		
			
			
}
	