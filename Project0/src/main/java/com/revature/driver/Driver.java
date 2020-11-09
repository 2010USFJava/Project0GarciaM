package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.beans.EmployeeUser;
import com.revature.menu.Menu;
import com.revature.util.BankData;
import com.revature.util.CustomerList;
import com.revature.util.EmployeeList;
import com.revature.util.FileUse;

public class Driver {

	//private static int counter;
	
	
	static {FileUse.readCustomerFile();
		//	FileUse.readEmployeeFile();
			FileUse.readBankFile();
	}
	
	protected static List<CustomerAccount> uList = new ArrayList<CustomerAccount>();
	protected static List<EmployeeUser> eList = new ArrayList<EmployeeUser>();
	protected static List<BankAccount> bList = new ArrayList<BankAccount>();
	
	
	public static void main(String[] args) {
		uList = CustomerList.userList;
		eList = EmployeeList.empList;
		bList = BankData.bankList;
		
		//Call main menu
		Menu.startMenu();
		
	}
}
