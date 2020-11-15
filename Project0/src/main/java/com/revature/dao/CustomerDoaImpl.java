package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.util.ConnFactory;

public class CustomerDoaImpl implements CustomerDoa{
	public static ConnFactory cf = ConnFactory.getInstance();
		
	@Override
	public void createNewCustomer() throws SQLException {
			Connection conn = cf.getConnection();	
			String sql = "insert into customer values(default,default,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, initialDeposit);
			ps.setInt(2, 0);
			ps.setString(3, "Checking");
			ps.executeUpdate();	
		
		
	}

	

}
