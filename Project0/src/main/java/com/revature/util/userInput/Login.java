package com.revature.util.userInput;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.LogThis;

public class Login {
	
	public static EmployeeDao emp = new EmployeeDaoImpl();
	public static CustomerDao cus = new CustomerDaoImpl();
	public static int currentBankAccount = 0;
	public static int currentEmployee = 0;
	public static int currentCustomer = 0;
	
	
	public static Scanner scan = new Scanner(System.in);
	
	public static boolean loginCustomer() {
		System.out.println("Customer Login: ");
		System.out.println("Please enter your email: ");
		String email = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		
		try {
			if(cus.customerLogin(email, password)) {
				return true;
			}
			else {
				System.out.println("Login Failed");
				LogThis.LogIt("info", "Customer Login failed email used " + email);
				return false;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
			
	
		public static boolean employeeLogin() {
			System.out.println("Employee Login: ");
			System.out.println("Please enter your email: ");
			String email = scan.nextLine();
			System.out.println("Please enter your password: ");
			String password = scan.nextLine();
			
			try {
				if(emp.loginEmployee(email, password)) {
					return true;
				}
				else {
					System.out.println("Login Failed");
					LogThis.LogIt("info", "Employee Login failed email used" + email );
					return false;
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
			
		}
	}
		
		


