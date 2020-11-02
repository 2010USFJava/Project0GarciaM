package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.menu.Menu;

public class BankData {
	
public static List<BankAccount> BankList = new ArrayList<BankAccount>();
	
	public static BankAccount findAccountByName(String inputName) {
		for (int i = 0; i < BankList.size(); i++) {
				String name = BankList.get(i).getOwnerName();
					return BankList.get(i);
		}
		System.out.println("Account not found");
		Menu.startMenu();
		return null;
		 
	}

}
