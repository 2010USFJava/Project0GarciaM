package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.CustomerList;

public class FileUse {
	
	public static final String CustomerFile ="CustomerList.txt";
	public static final String BankFile = "BankingFiles.txt";
	
	//write User method
	public static void writeCustomerFile(List<CustomerAccount> uList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(CustomerFile));
			objectOut.writeObject(uList);
			objectOut.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	//write bank account method
	public static void writeBankFile(List<BankAccount> bankList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(BankFile));
			objectOut.writeObject(bankList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//read Customer method
	public static void readCustomerFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(CustomerFile));
			CustomerList.userList = (ArrayList<CustomerAccount>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//read Bank account method
	public static void readBankFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(BankFile));
			BankData.bankList = (ArrayList<BankAccount>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
