package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.menu.Menu;

public class AccountList {
	
	public static List<UserAccount> userList = new ArrayList<UserAccount>();
	
	public static UserAccount findAccountByName(String inputName) {
		for (int i = 0; i < userList.size(); i++) {
				String name = userList.get(i).getUserName();
					return userList.get(i);
		}
		System.out.println("User not found");
		Menu.startMenu();
		return null;
		 
	}
}
