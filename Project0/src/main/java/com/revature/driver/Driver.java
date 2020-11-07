package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.beans.EmployeeUser;
import com.revature.menu.Menu;
import com.revature.util.CustomerList;
import com.revature.util.FileUse;

public class Driver {

	private static int counter;
	
	static {FileUse.readCustomerFile();}
	
	protected static List<CustomerAccount> uList = new ArrayList<CustomerAccount>();
	protected static List<EmployeeUser> empList = new ArrayList<EmployeeUser>();
	protected static List<BankAccount> bankList = new ArrayList<BankAccount>();
	
	
	public static void main(String[] args) {
		uList = CustomerList.userList;
		
		//Call main menu
		Menu.startMenu();
		
		System.out.println();
		
		
	//print customer list
		System.out.println("customer list");
	for (CustomerAccount lc: uList ) {
			System.out.println(lc);
	}
	//print employee list
			System.out.println("employee list");
	for (EmployeeUser le: empList ) {
		System.out.println(le);
}
	//print Bank account list
//			System.out.println("bank account list");
//	for (BankAccount lb: bankList ) {
//		System.out.println(lb);
//}
	
	}
}
