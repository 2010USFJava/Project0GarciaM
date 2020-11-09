package com.revature.service;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.BankData;
import com.revature.util.CustomerList;
import com.revature.util.FileUse;
import com.revature.util.LogThis;
import com.revature.util.userInput.GetInput;
import com.revature.util.userInput.InputValidation;

public class TransacService {

	static Scanner scan = new Scanner(System.in);
	public static void checkBalance() {
		System.out.println("The balance of you account is: $");
		System.out.println(GetInput.currentBankAccount.getAccountBalance());
	}
	
	public static void withdrawAccount() {
		printBalance();
		System.out.println("How much would you like to withdraw");
		int amount = Integer.parseInt(scan.nextLine());
		if (InputValidation.ValidateValue(amount) && InputValidation.OverdrawCheck(amount)) {
			int newBalance = GetInput.currentBankAccount.getAccountBalance() - amount;
			//set new balance in object in array
			BankData.findAccountByAccountNumber(GetInput.currentBankAccount.getAccountNumber()).setAccountBalance(newBalance);
			//increment transaction account in array
			BankData.findAccountByAccountNumber(GetInput.currentBankAccount.getAccountNumber()).setTransactionCount(GetInput.currentBankAccount.getTransactionCount()+1);
			FileUse.writeBankFile(BankData.bankList);
			
			LogThis.LogIt("info", "Balance was withdrawn $" + amount + "from " + GetInput.currentBankAccount.getAccountNumber());
		}
		else {
			System.out.println("The value entered is not valid or will overdraw account please try again");
			withdrawAccount();
		}
	}
	
	public static void depositAccount() {
		printBalance();
		System.out.println("Enter the amount you would like to deposit" );
		int deposit = Integer.parseInt(scan.nextLine());
		if  (InputValidation.ValidateValue(deposit)) {
			int newBalance = GetInput.currentBankAccount.getAccountBalance() + deposit;
			System.out.println("New Balance = $" + newBalance);
			BankData.findAccountByAccountNumber(GetInput.currentBankAccount.getAccountNumber()).setAccountBalance(newBalance);
			FileUse.writeBankFile(BankData.bankList);
			LogThis.LogIt("info", "A deposit has been made " + deposit + "added to account " +GetInput.currentBankAccount.getAccountNumber());
		}
	}
	
	public static void transferAccount() {
		System.out.println("Which account would you like to transfer too? Please enter account number: ");
		int transferAccount = Integer.parseInt(scan.nextLine());
		
	}
	
	public static void printBalance() {
		System.out.println("Current balance is: $");
		System.out.println(GetInput.currentBankAccount.getAccountBalance());
	}
	
	public static void approvalCheck() {
		System.out.println("Checking aproval status: ");
		if (GetInput.currentCustomer.getAccountNumber() > 1000) {
			System.out.println("Status Approved ");
		}
		else
			System.out.println("Application still pending approval");
		}
	
	public static int getHighest() {
		int highestAccount = 1000;
		for (BankAccount lb: BankData.bankList ) {
			for (BankAccount lc: BankData.bankList  ) {
				if(lb.getAccountNumber() > lc.getAccountNumber())
					highestAccount = lb.getAccountNumber();	
			}
		}		//increments the account number to next highest
		highestAccount++;
		System.out.println("Highest account found");
		
		

		
		return highestAccount;
	}
}