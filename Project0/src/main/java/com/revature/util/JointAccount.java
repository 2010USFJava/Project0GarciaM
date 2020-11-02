package com.revature.util;

public class JointAccount extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 856259149091652710L;
	
	private  String jointUserName;

	public JointAccount (String jointUserName) {
		this.jointUserName = jointUserName;
		System.out.println("This is a joint account");
	}

	public String getJointUserName() {
		return jointUserName;
	}

	public void setJointUserName(String jointUserName) {
		this.jointUserName = jointUserName;
	}
	
	
}

