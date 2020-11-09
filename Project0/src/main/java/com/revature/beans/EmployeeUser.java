package com.revature.beans;

import java.io.Serializable;

import com.revature.util.CustomerList;
import com.revature.util.EmployeeList;
import com.revature.util.FileUse;
import com.revature.util.LogThis;

public class EmployeeUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4142330159889259742L;
	protected int employeeNumber;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userAddress;
	private String userPhone;
	private boolean isAdmin;
	
	public EmployeeUser() {
		super();
		LogThis.LogIt("info", "A new empty employee account created");

	}

	public EmployeeUser(int employeeNumber, String userEmail, String userPassword, String userName, String userAddress,
			String userPhone, boolean isAdmin) {
		super();
		this.employeeNumber = employeeNumber;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.isAdmin = isAdmin;
		EmployeeList.empList.add(this);
		FileUse.writeEmployeeFile(EmployeeList.empList);
		LogThis.LogIt("info", "A new employee account created belongs to" + userName);

	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
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


	public boolean isAdmin() {
		return isAdmin;
	}

	public void isAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
		
		

	}

	
	
	
	
	


