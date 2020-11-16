package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.menu.Menu;
import com.revature.util.LogThis;
import com.revature.util.userInput.Login;
public class TransactionMenu {
	
	public static void transactionMenu() {
		BankAccountDao b = new BankAccountDaoImpl();
		boolean login = false;
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the transaction menu");
		System.out.println("**********************************");
		System.out.println("Please make a choice");
		System.out.println("[c]check account balance");
		System.out.println("[w]ithdraw from account");
		System.out.println("[m]ake a deposit into account");
		System.out.println("[d]elete all accounts");
		System.out.println("[b]ack to previous menu");
		System.out.println("[q]uit application");
		System.out.println("**********************************");
				
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()){ 
			case "c":
			try {
				System.out.println("Current balance: $" +b.viewBalance(Login.currentBankAccount));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				TransactionMenu.transactionMenu();
				break;	
			case "w":
			try {
				b.withdrawAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				TransactionMenu.transactionMenu();
				break;
			case "m":
			try {
				b.depositAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				TransactionMenu.transactionMenu();
				break;
			case "d":
			try {
				if (b.viewBalance(Login.currentBankAccount)> 0) {
					System.out.println("You must empty account first before deleting");
					TransactionMenu.transactionMenu();
				}
				else
					TransacService.deleteBothAccounts(Login.currentBankAccount);
					Menu.startMenu();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "b":
					LogThis.LogIt("info", "Customer has logged out number: " + Login.currentCustomer);
					Login.currentCustomer = 0;
					login = false;
				
					Menu.customerPortal();
				break;
			case "q":
				System.out.println("Thanks for banking with us");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input please try again");
				transactionMenu();
				break;
	}
		
}

}