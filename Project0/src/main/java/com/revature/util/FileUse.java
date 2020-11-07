package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.revature.beans.CustomerAccount;
import com.revature.beans.EmployeeUser;
import com.revature.util.CustomerList;

public class FileUse {
	
	public static final String CustomerFile ="CustomerList.txt";
	public static final String BankFile = "BankingFiles.txt";
	public static final String EmployeeFile = "EmployeeList.txt";
	
	//write User method
	public static void writeCustomerFile(List<CustomerAccount> UList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(CustomerFile));
			objectOut.writeObject(UList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//write bank account method
	public static void writeBankFile(List<CustomerAccount> bList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(BankFile));
			objectOut.writeObject(bList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//write employee method
	public static void writeEmployeeFile(List<EmployeeUser> eList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(EmployeeFile));
			objectOut.writeObject(eList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//read Customer method
	public static void readCustomerFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(CustomerFile));
			CustomerList.userList = (ArrayList<CustomerAccount>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//read Employee method
		public static void readEmployeeFile() {
			try {
				ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(EmployeeFile));
				CustomerList.userList = (ArrayList<CustomerAccount>)objectIn.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	//read Bank account method
	public static void readBankFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(BankFile));
			EmployeeList.empList = (ArrayList<EmployeeUser>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
