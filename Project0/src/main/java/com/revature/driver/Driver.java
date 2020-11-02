package com.revature.driver;

import java.util.ArrayList;
import java.util.List;


import com.revature.menu.Menu;
import com.revature.util.AccountList;
import com.revature.util.FileUse;
import com.revature.util.UserAccount;

public class Driver {

	private static int counter;
	
	static {FileUse.readUserFile();}
	
	public static List<UserAccount> uList = new ArrayList<UserAccount>();
	
	
	public static void main(String[] args) {
		uList = AccountList.userList;
		//Call main menu
		Menu.startMenu();
		
		System.out.println();
		
		
	for (UserAccount l: uList ) {
			System.out.println(l);
	}
	}
}
