package com.revature.util;

public class EmployeeUser extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4142330159889259742L;
	protected int employeeNumber;
	
	public EmployeeUser() {
		super();

	}

	public EmployeeUser(String userEmail, String userPassword, String userName, String userAddress, String userPhone,
			boolean isEmployee, boolean jointAccount, int employeeNumber ) {
		super(userEmail, userPassword, userName, userAddress, userPhone, isEmployee, jointAccount);
		this.employeeNumber = employeeNumber;
		
		

	}

	@Override
	public String toString() {

		return  "UserAccount [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", isEmployee=" + isEmployee
				+ ", jointAccount=" + jointAccount  + "EmployeeNumber"+ employeeNumber + "]";
	}

	public int getemployeeNumber() {
		return employeeNumber;
	}

	public  void setemployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	
	
	
	

}
