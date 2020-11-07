package com.revature.util.userInput;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.EmployeeUser;
import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;
import com.revature.service.Transaction;

public class GetInput {
	static Scanner scan = new Scanner(System.in);

	public static void UserAccountInput() {
		boolean isEmployee = false;
		boolean validEmail = false;
		boolean validPhone = false;
		boolean isAdmin = false;
		boolean isJointAccount = false;
		String userEmail;
		String phone;
		int employeeNumber= 0;
		int jNumAccount = 0;
		
		
		
		do {
		userEmail = "";
		System.out.println("Please enter a email for your account: ");
		userEmail = scan.nextLine();
		if (userEmail.contains("@"))
			validEmail = true;
		else
			validEmail = false;
			System.out.println("Please enter a valid email");
		} while(validEmail == false);
		
		System.out.println("Please enter your password for your account: ");
		String password = scan.nextLine();
		
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
		System.out.println("Please enter your Address: ");
		String address = scan.nextLine();
		
		do {
			System.out.println("Please enter your phone number for your account: ");
			phone = scan.nextLine();
			if (phone.length() > 10 ) {
				validPhone = false;
				System.out.println("Please enter correct number of digits with no spaces");
			}
			else
				validPhone = true;
		} while (validPhone == false);
		
		System.out.println();
		
		System.out.println("Is this an employee account? (y/n)");
		String isEMP = scan.nextLine();
		
		if(isEMP.equalsIgnoreCase("y")) {
			if (isEMP.equalsIgnoreCase("y") && userEmail.contains("revature")) {
				isEmployee = true;
				System.out.println("Please enter employee number");
				employeeNumber = Integer.parseInt(scan.nextLine());
				System.out.println("Are you an admin? y/n");
				String adminChoice = scan.next();
				
				if (adminChoice.equalsIgnoreCase("y"))
					isAdmin = true;
				else
					isAdmin = false;
			}
			else if (isEmployee == false && isEMP.equalsIgnoreCase("y")) {
				
				System.out.println("Your email is not an employee email, \n customer account will be created");
				createCustomer(userEmail,password,name,address,phone,jNumAccount);
				}
			else
				createCustomer(userEmail,password,name,address,phone,jNumAccount);
		}
			

		
		if (isEmployee == false) {
			jNumAccount = 0;
			System.out.println("Will this be a joint account? (y/n)");
			String jAccount = scan.nextLine();
			
			if (jAccount.equalsIgnoreCase("y")) {
				isJointAccount = true;
				System.out.println("Please enter joint account number if it exists otherwise enter 0");
				jNumAccount = Integer.parseInt(scan.nextLine());
			}	
			else if (jAccount.equalsIgnoreCase("n")) {
				isJointAccount = false;
				createCustomer(userEmail,password,name,address,phone,jNumAccount);
			}
			if (isJointAccount) {
				if (jNumAccount > 0) {
					//check if joint account exists then j account will equal exisint account call constructor
					
				}
				else {
					createCustomer(userEmail,password,name,address,phone,jNumAccount);
					System.out.println("Please create the joint account");
					UserAccountInput();
				}
			}	
			
		
		}
		else  if  (isEmployee == true) {
			createEmployee(employeeNumber,  userEmail, password,  name,  address,
					 phone,  isAdmin);
			
			
		}
	}
	
	public static void createEmployee(int employeeNumber, String userEmail, String userPassword, String userName, String userAddress,
			String userPhone, boolean isAdmin) {
		EmployeeUser a = new EmployeeUser( employeeNumber,  userEmail, userPassword,  userName,  userAddress,
				userPhone,  isAdmin);
		LogThis.LogIt("info",a.getUserName() + " employee account was created! ");
		System.out.println("Employee Account Created" + "employee number: " + employeeNumber);
		System.out.println(a); //check to test valid input remove later
	}
	
	public static void createCustomer(String userEmail, String password, String name, String address, String phone, int jNumAccount) {
		CustomerAccount a = new CustomerAccount(userEmail,password,name,address,phone,jNumAccount);
		LogThis.LogIt("info",a.getUserName() + " account was created!");
		System.out.println(a); //check to test valid input remove later
		System.out.println("Your application has been accepted please wait for aprovall");
	}
	
	public static boolean InputLogin() {
		System.out.println("Enter the email address on account");
		String email = scan.nextLine();
		CustomerAccount a = CustomerList.findAccountByEmail(email);
		System.out.println("Enter your password");
		String password = scan.nextLine();
		CustomerAccount b = CustomerList.findAccountByPassword(password);
		
		if(a.equals(b)) {
			System.out.println("Login Successful!");
			LogThis.LogIt("info", "Login Successful for " + a.getUserEmail());
			return true;
		}
		else {
			System.out.println("Login Failed");
			LogThis.LogIt("info", "Login Failed for " + a.getUserEmail());
			return false;
		}
	}
}
