package com.revature.beans;

import java.io.Serializable;

import com.revature.util.LogThis;

public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5417792914593550047L;
	
	private int accountNumber = 0;
	private double accountBalance;
	private String accountType;
	private int transactionCount;
	
	public BankAccount() {
		super();
		LogThis.LogIt("info", "A new empty account created ");
	}

	public BankAccount(int accountNumber, double accountBalance, int transactionCount, String accountType) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.transactionCount = transactionCount;
	
		LogThis.LogIt("info", "A new bank account created for " + "AccountNum: " + this.getAccountNumber());
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
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

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", accountType=" + accountType + ", transactionCount=" + transactionCount + "]";
	}
	
	
	
	

}
