package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.EmployeeUser;
import com.revature.menu.Menu;

public class EmployeeList {
	
	public static List<EmployeeUser> empList = new ArrayList<EmployeeUser>();
	
	public static EmployeeUser findAccountByEmail(String inputName) {
		for (int i = 0; i < empList.size(); i++) {
			String name= empList.get(i).getUserEmail();
			if(inputName.equals(name)) {
				return empList.get(i);
			}
		}
		System.out.println("User not found");
		Menu.startMenu();
		return null;
		 
	
}
	
	public static EmployeeUser findAccountByPassword(String inputName) {
		for (int i = 0; i < empList.size(); i++) {
				String name = empList.get(i).getUserPassword();
				if(inputName.equals(name))
					return empList.get(i);
		}
		System.out.println("Password not found");
		Menu.startMenu();
		return null;
		 
	}
}
