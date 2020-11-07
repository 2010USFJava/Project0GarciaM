package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerAccount;
import com.revature.menu.Menu;

public class CustomerList {
	
	public static List<CustomerAccount> userList = new ArrayList<CustomerAccount>();
	
	public static CustomerAccount findAccountByEmail(String inputName) {
		for (int i = 0; i < userList.size(); i++) {
			String name= userList.get(i).getUserEmail();
			if(inputName.equals(name)) {
				return userList.get(i);
			}
		}
		System.out.println("User not found");
		Menu.startMenu();
		return null;
		 
	
}
	
	public static CustomerAccount findAccountByPassword(String inputName) {
		for (int i = 0; i < userList.size(); i++) {
				String name = userList.get(i).getUserPassword();
				if(inputName.equals(name))
					return userList.get(i);
		}
		System.out.println("Password not found");
		Menu.startMenu();
		return null;
		 
	}
}
