package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.util.AccountList;
import com.revature.util.LogThis;
import com.revature.util.UserAccount;
import com.revature.service.Transaction;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to our Banking app!");
		System.out.println("Please enter a choice: ");
		System.out.println("\t [c]reate a new User Account");
		System.out.println("\t [l]ogin to an existing Account");
		System.out.println("\t [q]uit the app");
		
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()) {
			case "c":
				createMenu();
				break;
			case "l":
				loginMenu();
				break;
			case "q":
				System.out.println("Have a nice day!");
				break;
				default:
					System.out.println("Invalid input please try again");
					startMenu();
					break;
		
		}
	}
	
	public static void createMenu() {
		boolean isEmployee;
		System.out.println("Create a new user");
		System.out.println("Please enter a email for your account: ");
		String userEmail = scan.nextLine();
		System.out.println("Please enter your password for your account: ");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Please enter your Address: ");
		String address = scan.nextLine();
		System.out.println("Please enter your phone number for your account: ");
		String phone = scan.nextLine();
		System.out.println();
		System.out.println("Is this an employee account? (y/n)");
		String isEMP = scan.nextLine();
		if (isEMP.equalsIgnoreCase("y"))
			isEmployee = true;
		else
			isEmployee = false;
		
		UserAccount a = new UserAccount(userEmail,password,name,address,phone, isEmployee);
		LogThis.LogIt("info",a.getUserName() + " account was created!");
		System.out.println(AccountList.userList.toString());
		
		System.out.println("Would you like to make a new account? (y/n)");
		String choice = scan.nextLine();
		if(choice.equalsIgnoreCase("y"))
			createMenu();
		
		else if (choice.equalsIgnoreCase("n")) {
			startMenu();
		}
		else {
			System.out.println(" You are going back to the main menu");
//			startMenu();
			
	}
	}
	
	public static void loginMenu(){
////		System.out.println("Enter the email address on account");
////		String email = scan.nextLine();
////		UserAccount a = Accountlist.find(Email);
////		System.out.println("Enter your password");
////		String Password = scan.nextLine();
////		Warrior b = Roster.findWarriorByName(second);
////		
////		System.out.println("LET THE BATTLE BEGIN!!");
////		Fight fight = new Fight();
////		fight.fightTime(a, b);
////		LogThis.LogIt("info", a.getName() + " just punched " + b.getName() + " and it cost them " + a.getAttackPower()
////		+ " points of damage. ");
////		System.out.println(b.getName() + " HP is now " + b.getHp());
////		startMenu();
////				
//		
		
	}
	
}
