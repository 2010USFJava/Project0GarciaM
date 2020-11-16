package com.revature.beans;

import java.io.Serializable;

import com.revature.util.LogThis;

public class CustomerAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928222056777250302L;
	
	private int userID;
	private int bankID;
	private String userLastName;
	private String userFirstName;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	
	public CustomerAccount() {
		super();
	}
	
	public CustomerAccount(int userID, int bankID,String userLastName, String userFirstName, String userEmail,
				String userPassword,  String userPhone) {
		super();
		this.userID = userID;
		this.bankID = bankID;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.userPhone = userPhone;
	}

	public int getUserID() {
		return userID;
	}

	public void setUser_ID(int userID) {
		this.userID = userID;
	}

	public int getBank_ID() {
		return bankID;
	}

	public void setBank_ID(int bankID) {
		this.bankID = bankID;
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

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
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
		return "CustomerAccount [userID=" + userID + ", bankID=" + bankID + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userLastName=" + userLastName + ", userFirstName="
				+ userFirstName + ", userPhone=" + userPhone + "]";
	}
	
	 
	
	
	
}
	
