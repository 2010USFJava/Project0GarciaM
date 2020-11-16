package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.menu.Menu;
import com.revature.util.userInput.Login;
public class TransactionMenu {
	
	public static void transactionMenu() {
		BankAccountDao b = new BankAccountDaoImpl();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the transaction menu");
		System.out.println("Please make a choice");
		System.out.println("[c]check account balance");
		System.out.println("[w]ithdraw from account");
		System.out.println("[d]eposit into account");
		System.out.println("[b]ack to previus menu");
		System.out.println("[q]quit application");
				
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()){ 
			case "c":
			try {
				System.out.println("Current balance: " +b.viewBalance(Login.currentBankAccount));
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
			case "d":
			try {
				b.depositAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				TransactionMenu.transactionMenu();
				break;
			case "b":
				Menu.startMenu();
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
