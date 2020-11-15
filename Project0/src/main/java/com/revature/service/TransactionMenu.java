package com.revature.service;

import java.util.Scanner;

import com.revature.menu.Menu;
public class TransactionMenu {
	
	public static void transactionMenu() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the transaction menu");
		System.out.println("Please make a choice");
		System.out.println("[c]check account balance");
		System.out.println("[w]ithdraw from account");
		System.out.println("[d]eposit into account");
		System.out.println("[t]ransfer to another account");
		System.out.println("[b]ack to previus menu");
		System.out.println("[q]quit application");
				
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()){ 
			case "c":
				TransacService.checkBalance();
				TransactionMenu.transactionMenu();
				break;	
			case "w":
				TransacService.withdrawAccount();
				TransactionMenu.transactionMenu();
				break;
			case "d":
				TransacService.depositAccount();
				TransactionMenu.transactionMenu();
				break;
			case "t":
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
