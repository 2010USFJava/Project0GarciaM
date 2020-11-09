package com.revature.util.userInput;

public class InputValidation {

	public static boolean ValidateValue(int value){
		return value > 0;
	}	
	
	public static boolean OverdrawCheck(int value) {
		return GetInput.currentBankAccount.getAccountBalance()- value > 0;
		
	}
	
	
}
