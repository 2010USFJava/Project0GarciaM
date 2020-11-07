package com.revature.beans;

import java.io.Serializable;

import com.revature.util.CustomerList;
import com.revature.util.FileUse;
import com.revature.util.LogThis;

public class CustomerAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928222056777250302L;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userAddress;
	private String userPhone;
	int jointAccount;
	
	
	public CustomerAccount() {
		super();
		CustomerList.userList.add(this);
		FileUse.writeCustomerFile(CustomerList.userList);
		LogThis.LogIt("info", "A new user account created");
		
	}
	
	public CustomerAccount(String userEmail, String userPassword, String userName, String userAddress, String userPhone,
			int jointAccount) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		
		this.jointAccount = jointAccount;
		CustomerList.userList.add(this);
		FileUse.writeCustomerFile(CustomerList.userList);
		LogThis.LogIt("info", "A new user account created for" + this.getUserName());
	}

	public int isisJointAccount() {
		return jointAccount;
	}

	public void setisJointAccount(int jointAccount) {
		this.jointAccount = jointAccount;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	
	
	@Override
	public String toString() {
		return "UserAccount [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone 
				+ ", jointAccountNumber=" + jointAccount + "]";
	}

	
	
	
	
	
}
