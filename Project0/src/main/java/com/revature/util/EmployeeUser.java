package com.revature.util;

public class EmployeeUser extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4142330159889259742L;

	
	private static int EmployeeNumber;
	
	public EmployeeUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeUser(String userEmail, String userPassword, String userName, String userAddress, String userPhone,
			boolean isEmployee, boolean jointAccount, int EmployeeNumber ) {
		super(userEmail, userPassword, userName, userAddress, userPhone, isEmployee, jointAccount);
		
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
