//package com.revature.ServiceTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//import org.junit.Test;
//
//import com.revature.beans.BankAccount;
//import com.revature.service.TransacService;
//
//
//public class TransacServiceTest {
//	
//	static BankAccount a = new BankAccount();
//	static BankAccount b = new BankAccount();
//
//	@Test
//	public void testCheckBalance() {
//	
//		b.setAccountBalance(200);
//		
//		double actual = b.getAccountBalance();
//		assertEquals((int)200,(int)actual);
//	}
//
//	@Test
//	public void testWithdrawAccount() {
//		
//		b.setAccountBalance(200.0);
//		
//		double actual = withdraw(100.0);
//		
//		assertEquals((int)200,(int)actual);
//	}
//
//	@Test
//	public void testDeposit() {
//	a.setAccountBalance(100.0);
//	
//	TransacService.deposit(100.0);
//	double actual = 200;
//	
//	double expected = 200;
//	
//	assertEquals((int)expected,(int)actual);
//	}
//
//		
//		
//	}
//	@Test
//	public void testPrintBalance() {
//		
//	}
//
//	@Test
//	public void testApprovalCheck() {
//		BankAccount b = new BankAccount();
//		b.setAccountBalance(200);
//		
//		double actual = b.getAccountBalance();
//		assertEquals(200,actual);
//	}
//
//	@Test
//	public void testGetHighest() {
//		
//	}
//
//}
