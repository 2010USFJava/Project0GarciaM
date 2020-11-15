package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//Singleton Factory
	//private static instance of itself
	
	// no new object is created yet
	private static ConnFactory cf;
		
	
	
	//punlic static synchronized "getter" method 
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
	}
		return cf;
	}
	
	//methods that do stuff
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return conn;
	}

}
