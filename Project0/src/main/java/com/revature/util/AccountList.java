package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.menu.Menu;

public class AccountList {
	
	public static List<UserAccount> userList = new ArrayList<UserAccount>();
	
	public static UserAccount findAccountByEmail(String inputName) {
		for (int i = 0; i < userList.size(); i++) {
			String name= userList.get(i).getUserName();
			if(inputName.equals(name)) {
				return userList.get(i);
			}
		}
		System.out.println("User not found");
		Menu.startMenu();
		return null;
		 
	
}
	
	public static UserAccount findAccountByPassword(String inputName) {
		for (int i = 0; i < userList.size(); i++) {
				String name = userList.get(i).getUserPassword();
					return userList.get(i);
		}
		System.out.println("Password not found");
		Menu.startMenu();
		return null;
		 
	}
}
