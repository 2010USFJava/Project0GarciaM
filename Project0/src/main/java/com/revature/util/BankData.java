package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.menu.Menu;

public class BankData {
	
public static List<BankAccount> bankList = new ArrayList<BankAccount>();
	
	public static BankAccount findAccountByAccountNumber(int accountNum) {
		for (int i = 0; i < bankList.size(); i++) {
				int accountNumber = bankList.get(i).getAccountNumber();
				if(accountNum == accountNumber) {	
					return bankList.get(i);
				}
			}
		System.out.println("Account not found");
		Menu.startMenu();
		return null;
		 
	}
	
	public static BankAccount findAccountByAccountName(String inputName) {
		for (int i = 0; i < bankList.size(); i++) {
				String accountName = bankList.get(i).getOwnerName();
				if(inputName.equals(accountName)) {	
					return bankList.get(i);
				}
		}
		System.out.println("Account not found");
		Menu.startMenu();
		return null;
		 
	}
	
	
		 
}
	

