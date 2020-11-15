package com.revature.util.userInput;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;
import com.revature.service.TransactionMenu;

public class GetInput {
	static Scanner scan = new Scanner(System.in);
	public static CustomerAccount currentCustomer;
	public static BankAccount currentBankAccount;
	public static BankAccount transferBankAccount;

	public static void getCustomerInfo() {
		boolean validEmail = false;
		boolean validPhone = false;
		boolean isJointAccount = false;
		String userEmail;
		String phone;
		int employeeNumber= 0;
		
		
		
		do {
			System.out.println("Please enter a email for your account: ");
			userEmail = scan.nextLine();
			if (userEmail.contains("@") && userEmail.contains(".") && !userEmail.contains(" "))
				validEmail = true;
			else {
				validEmail = false;
				System.out.println("Please enter a valid email");
			}
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
		
	
	}
			
			
			
	
	
	public static void createCustomer(String userEmail, String password, String name, String address, String phone) {
		CustomerAccount a = new CustomerAccount(userEmail,password,name,address,phone);
		LogThis.LogIt("info",a.getUserLastName() + " account was created!");
		System.out.println(a); //check to test valid input remove later
		System.out.println("Your application has been accepted please wait for aprovall");
		
	}
}
	
			
				
