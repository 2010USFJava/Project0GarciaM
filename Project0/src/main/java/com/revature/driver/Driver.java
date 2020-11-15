package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.menu.Menu;
import com.revature.util.CustomerList;


public class Driver {	
	
//	static {FileUse.readCustomerFile();
//
//			FileUse.readBankFile();
//	}
	
//	protected static List<CustomerAccount> uList = new ArrayList<CustomerAccount>();
//	protected static List<BankAccount> bList = new ArrayList<BankAccount>();
	
	
	public static void main(String[] args) {
		
		//BankAccountDao ba = new BankAccountDaoImpl();
		
//		try {
//			ba.createBankAccount(100.0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//Call main menu
		Menu.startMenu();
		
		
		
	}

}