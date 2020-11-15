package com.revature.util.userInput;

import java.util.Scanner;

import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;

public class Login {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static boolean loginCustomer() {
		System.out.println("Enter the email address on account");
		String email = scan.nextLine();
		
		//System.out.println(a);
		System.out.println("Enter your password");
		String password = scan.nextLine();
		
		
		//	LogThis.LogIt("info", "Login Successful for " + a.getUserEmail());
				
			return true;
			
//		}
//		else {
//			System.out.println("Login Failed");
//			LogThis.LogIt("info", "Login Failed for " + a.getUserEmail());
//			return false;
		
		}	
	}
		
		


