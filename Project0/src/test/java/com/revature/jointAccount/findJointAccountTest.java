package com.revature.jointAccount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.CustomerAccount;

public class findJointAccountTest {
	
	static CustomerAccount a;
	static CustomerAccount b;
	

	
	@Test
	public void JointAccountTest() {
		System.out.println("setting values of a and b");
		CustomerAccount a = new CustomerAccount();
		a.setAccountNumber(100);
		b = a;
		assert(a.equals(b));
	}

}
