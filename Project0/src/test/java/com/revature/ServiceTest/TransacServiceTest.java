package com.revature.ServiceTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.service.TransacService;
import com.revature.util.userInput.Login;


public class TransacServiceTest {
	
	BankAccountDao b = new BankAccountDaoImpl();
	
	
	@Test
	public void testWithdrawAccount() {
		
		double actual = TransacService.withdraw(100);
		assertEquals((Double)(-100.0),(Double)actual);
	}

//	@Test
	public void testDeposit() {	
	
	double actual = TransacService.deposit(100.0);
	
	
	double expected = 100;
	
	assertEquals((Double)expected,(Double)actual);
	}

}
		
