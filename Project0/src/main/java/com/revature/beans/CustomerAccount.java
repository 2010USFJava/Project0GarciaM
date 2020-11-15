package com.revature.beans;

import java.io.Serializable;

import com.revature.util.CustomerList;
import com.revature.util.LogThis;

public class CustomerAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928222056777250302L;
	private String userEmail;
	private String userPassword;
	private String userLastName;
	private String userFirstName;
	private String userPhone;
	//int jointAccount;
	//default empty account number
	int accountNumber = 1000;
	
	
	public CustomerAccount() {
		super();
		LogThis.LogIt("info", "A new empty account created");
		
	}
	
	public CustomerAccount(String userEmail, String userPassword, String userLastName, String userFirstName, String userPhone) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.userPhone = userPhone;
		
		LogThis.LogIt("info", "A new user account created for " + this.getUserLastName());
	}

	public int 	getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setuserLastName(String userName) {
		this.userLastName = userName;
	}
	
	public String getuserFirstName() {
		return userFirstName;
	}
	
	public void setuserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	
	
	@Override
	public String toString() {
		return "CustomerAccount [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userLastName=" + userLastName
				+ ", userFirstName=" + userFirstName
				+ ", userPhone=" + userPhone 
				+ ", jointAccountNumber=" + "Account Number"+ accountNumber +"]";
	}

	
	
	
	
	
}
