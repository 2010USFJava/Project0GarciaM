package com.revature.service;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.BankData;
import com.revature.util.CustomerList;
import com.revature.util.FileUse;
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
		for (BankAccount lb:BankData.bankList) {
			System.out.println(lb);
		}
	}
	
	public static void approveAccounts() {
		String choice = "";
		
		System.out.println("Printing all unapproved accounts");
		for (CustomerAccount lc: CustomerList.userList) {
			if (lc.getAccountNumber() == 1000) {
				System.out.println(lc);
				}
			}
				while (choice.equals("n") == false) {
				int highest = 0;
				System.out.println("Would you like to approve any accounts? Choose via email, [n] to exit ");
				choice= scan.nextLine().toLowerCase();
									
				System.out.println(CustomerList.findAccountByEmail(choice));
				CustomerAccount a =CustomerList.findAccountByEmail(choice);
				highest = TransacService.getHighest();
				BankAccount newestAccount = new BankAccount(highest, a.getUserName(), 0, "Checking",0);	
				System.out.println("Account Approved for " + newestAccount);
				GetInput.currentBankAccount = newestAccount;
				System.out.println(" current " + GetInput.currentBankAccount);
				CustomerList.findAccountByEmail(a.getUserEmail()).setAccountNumber(highest);
				System.out.println(" Array Customer "+CustomerList.findAccountByEmail(a.getUserEmail()).getAccountNumber());
				FileUse.writeCustomerFile(CustomerList.userList);
				LogThis.LogIt("info","Account Number changed for customer " + a.getUserName());
				} 
				
			 
			
	}
}
	
	

