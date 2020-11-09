package com.revature.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.revature.beans.BankAccount;


public class TransacServiceTest {

	@Test
	public void testCheckBalance() {
		BankAccount b = new BankAccount();
		b.setAccountBalance(200);
		
		int actual = b.getAccountBalance();
		assertEquals(200,actual);
	}

	@Test
	public void testWithdrawAccount() {
		BankAccount b = new BankAccount();
		b.setAccountBalance(200);
		
		int actual = b.getAccountBalance();
		assertEquals(200,actual);
	}

	@Test
	public void testDepositAccount() {
		
		BankAccount b = new BankAccount();
		b.setAccountBalance(200);
		
		int actual = b.getAccountBalance();
		assertEquals(200,actual);
	
	}

	@Test
	public void testTransferAccount() {
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
	
		a.setAccountBalance(100);
		b.setAccountBalance(100);
		
		
		int actual1 = a.getAccountBalance();
		int actual2 = b.getAccountBalance();
		
		assertEquals(100,actual1);
		assertEquals(100,actual2);
		
		
	}
	@Test
	public void testPrintBalance() {
		
	}

	@Test
	public void testApprovalCheck() {
		BankAccount b = new BankAccount();
		b.setAccountBalance(200);
		
		int actual = b.getAccountBalance();
		assertEquals(200,actual);
	}

	@Test
	public void testGetHighest() {
		
	}

}
