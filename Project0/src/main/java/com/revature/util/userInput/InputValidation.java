package com.revature.util.userInput;

public class InputValidation {
	
	
	public static boolean ValidateValue(double value){
		return value > 0;
	}	
	
	public static boolean OverdrawCheck(double value) {
		return  true; //Login.currentBankAccount
					//getAccountBalance() - value > 0;
		
	}
	
	
}
