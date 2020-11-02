package com.revature.beans;

import java.io.Serializable;

public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5417792914593550047L;
	
	private int accountNumber;
	private String ownerName;
	private int accountBalance;
	private String accountType;
	private int transactionCount;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int accountNumber, String ownerName, int accountBalance, String accountType,
			int transactionCount) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.transactionCount = transactionCount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}
	
	
	
	

}
