package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.menu.Menu;

public class BankData {
	
public static List<BankAccount> BankList = new ArrayList<BankAccount>();
	
	public static BankAccount findAccountByAccountNumber(String inputName) {
		for (int i = 0; i < BankList.size(); i++) {
				int accountNumber = BankList.get(i).getAccountNumber();
					return BankList.get(i);
		}
		System.out.println("Account not found");
		Menu.startMenu();
		return null;
		 
	}
	
	public static BankAccount findAccountByAccountName(String inputName) {
		for (int i = 0; i < BankList.size(); i++) {
				String accountName = BankList.get(i).getOwnerName();
					return BankList.get(i);
		}
		System.out.println("Account not found");
		Menu.startMenu();
		return null;
		 
	}
	
		 
}
	

