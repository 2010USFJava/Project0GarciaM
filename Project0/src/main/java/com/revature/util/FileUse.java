package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.revature.util.AccountList;

public class FileUse {
	
	public static final String UserFile ="userFileList.txt";
	public static final String BankFile = "BankingFiles.txt";
	
	//write User method
	public static void writeUserFile(List<UserAccount> UList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(UserFile));
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
	public static void writeBankFile(List<UserAccount> bList) {
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
	
	//read User method
	public static void readUserFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(UserFile));
			AccountList.userList = (ArrayList<UserAccount>)objectIn.readObject();
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
//	public static void readBankFile() {
//		try {
//			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(BankFile));
//			//AccountList.userList = (ArrayList<UserAccount>)objectIn.readObject();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
