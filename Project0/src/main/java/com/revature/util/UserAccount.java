package com.revature.util;

import java.io.Serializable;

public class UserAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928222056777250302L;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userAddress;
	private String userPhone;
	private boolean isEmployee;
	private boolean jointAccount;
	
	public UserAccount() {
		super();
		this.isEmployee = false;
		AccountList.userList.add(this);
		FileUse.writeUserFile(AccountList.userList);
		LogThis.LogIt("info", "A new user account created");
		
	}
	
	public UserAccount(String userEmail, String userPassword, String userName, String userAddress, String userPhone,
			boolean isEmployee, boolean jointAccount) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.isEmployee = isEmployee;
		this.jointAccount = jointAccount;
		AccountList.userList.add(this);
		FileUse.writeUserFile(AccountList.userList);
		LogThis.LogIt("info", "A new user account created for" + this.getUserName());
	}

	public boolean isJointAccount() {
		return jointAccount;
	}

	public void setJointAccount(boolean jointAccount) {
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

	
	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	@Override
	public String toString() {
		return "UserAccount [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", isEmployee=" + isEmployee
				+ ", jointAccount=" + jointAccount + "]";
	}

	
	
	
	
	
}
