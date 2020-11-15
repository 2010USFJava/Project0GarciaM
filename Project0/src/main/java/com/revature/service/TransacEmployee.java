package com.revature.service;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.menu.EmployeePortal;
import com.revature.util.CustomerList;
import com.revature.util.LogThis;
import com.revature.util.userInput.GetInput;

public class TransacEmployee {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void printCustomerAccounts() {
		System.out.println("customer list");
		for (CustomerAccount lc: CustomerList.userList) {
				System.out.println(lc);
		}
	}
	
	public static void printBankAccounts() {
		
		}
	
	
	
				

	public static void deleteAccount() {
		System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS ACOUNT? y/n ");
		String choice = scan.nextLine();
		
		
	}
	
}
	
	

