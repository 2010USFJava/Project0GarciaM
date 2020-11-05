package com.revature.util.userInput;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.util.AccountList;
import com.revature.util.EmployeeUser;
import com.revature.util.LogThis;
import com.revature.util.UserAccount;
import com.revature.service.Transaction;

public class GetInput {
	static Scanner scan = new Scanner(System.in);

	public static void UserAccountInput() {
		boolean isEmployee = false;
		int EmployeeNumber;
		boolean isJointAccount = false;
		boolean validEmail = false;
		boolean validPhone = false;
		String userEmail;
		String phone;
		
		
		do {
		System.out.println("Please enter a email for your account: ");
		userEmail = scan.nextLine();
		if (userEmail.contains("@"))
			validEmail = true;
		else
			validEmail = false;
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
				System.out.println("Please enter correct number of digits");
			}
			else
				validPhone = true;
		} while (validPhone == false);
		
		System.out.println();
		
		System.out.println("Is this an employee account? (y/n)");
		String isEMP = scan.nextLine();
		
		if (isEMP.equalsIgnoreCase("y") && userEmail.contains("revature")) {
			isEmployee = true;
			System.out.println("Please enter employee number");
			EmployeeNumber = scan.nextInt();
		}
		else {
			isEmployee = false;
			System.out.println("Your email is not an employee email, \n customer account will be created");
		}
		
		System.out.println("Will this be a joint account? (y/n)");
		String jAccount = scan.nextLine();
		if (jAccount.equalsIgnoreCase("y"))
			isJointAccount = true;
		else
			isJointAccount = false;
		
		if (isEmployee == false) {
			UserAccount a = new UserAccount(userEmail,password,name,address,phone,isEmployee,isJointAccount);
			LogThis.LogIt("info",a.getUserName() + " account was created!");
			System.out.println(a); //check to test valid input remove later
			System.out.println("Your application has been accepted please wait for aprovall");
		
		}
		else {
			UserAccount a = new EmployeeUser(userEmail,password,name,address,phone,isEmployee,isJointAccount,1234);
			LogThis.LogIt("info",a.getUserName() + " employee account was created!");
			System.out.println(a); //check to test valid input remove later
			System.out.println("Employee Account Created");
			
		}
	}
	
	public static void InputLogin() {
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
	}
}
