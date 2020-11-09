package com.revature.service;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.menu.EmployeePortal;
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
		String deny = "";
		int highest = 0;
		
		System.out.println("Printing all unapproved accounts");
		for (CustomerAccount lc: CustomerList.userList) {
			if (lc.getAccountNumber() == 1000) {
				System.out.println(lc);
				}
			}
				while (choice.equals("n") == false) {
				
				System.out.println("Would you like to approve/deny any accounts? Choose via email, [n] to exit ");
				choice= scan.nextLine().toLowerCase();
				
				if(choice.contains("n")== false) {
					System.out.println("would you liketo deny this account ? y/n ");
					deny = scan.nextLine();
				}
				
				CustomerAccount a = CustomerList.findAccountByEmail(choice);
				
				if (deny.equals("y"))  {
						denyAccount(a);
					}	
				else if(a.getJointAccount() > 1000) {
					int jAccount = a.getJointAccount();
					BankAccount newestAccount = new BankAccount(jAccount, a.getUserName(), 0, "Checking",0);
					System.out.println("Account Approved for " + newestAccount);
					GetInput.currentBankAccount = newestAccount;
					System.out.println(" current " + GetInput.currentBankAccount);
					CustomerList.findAccountbyjointAccount(a.getJointAccount()).setAccountNumber(jAccount);
				}
				else {
					
					highest = TransacService.getHighest();
					BankAccount newestAccount = new BankAccount(highest, a.getUserName(), 0, "Checking",0);	
					System.out.println("Account Approved for " + newestAccount);
					GetInput.currentBankAccount = newestAccount;
					//changes customer object in array to new account number
					CustomerList.findAccountByEmail(a.getUserEmail()).setAccountNumber(highest);
				}
					FileUse.writeCustomerFile(CustomerList.userList);
					LogThis.LogIt("info","Account Number changed for customer " + a.getUserName());
				}
				
} 
				

	public static void denyAccount(CustomerAccount account) {
		CustomerList.findAccountByEmail(account.getUserEmail()).setAccountNumber(-1);
		FileUse.writeCustomerFile(CustomerList.userList);
		LogThis.LogIt("info", "Account denied for user: "+ account.getUserName());
	}
	
	public static void deleteAccount() {
		System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS ACOUNT? y/n ");
		String choice = scan.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			BankData.bankList.remove(BankData.findAccountByAccountNumber(GetInput.currentBankAccount.getAccountNumber()));
			CustomerList.userList.remove(CustomerList.findAccountbyNumber(GetInput.currentBankAccount.getAccountNumber()));
			FileUse.writeBankFile(BankData.bankList);
			FileUse.writeCustomerFile(CustomerList.userList);
			LogThis.LogIt("info", "Account deleted in both customer and bank account"+ GetInput.currentBankAccount.getAccountNumber());
		}
		else
			EmployeePortal.editMenu();
		
	}
	
}
	
	

