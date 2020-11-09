package com.revature.util.userInput;

import java.util.Scanner;

import com.revature.beans.CustomerAccount;
import com.revature.util.BankData;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;

public class Login {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static boolean loginCustomer() {
		System.out.println("Enter the email address on account");
		String email = scan.nextLine();
		CustomerAccount a = CustomerList.findAccountByEmail(email);
		System.out.println(a);
		System.out.println("Enter your password");
		String password = scan.nextLine();
		CustomerAccount b = CustomerList.findAccountByPassword(password);
		System.out.println(b);
			if(a.equals(b)) {
			System.out.println("Login Successful!");
			LogThis.LogIt("info", "Login Successful for " + a.getUserEmail());
			GetInput.currentBankAccount = BankData.findAccountByAccountName(a.getUserName());
			GetInput.currentCustomer = a;	
			return true;
			
		}
		else {
			System.out.println("Login Failed");
			LogThis.LogIt("info", "Login Failed for " + a.getUserEmail());
			return false;
		
		}	
	}
		
		

}
