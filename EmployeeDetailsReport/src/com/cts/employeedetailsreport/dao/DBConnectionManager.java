package com.cts.employeedetailsreport.dao;


import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnectionManager {

 
	 
	 private static Connection con = null;
	 private static DBConnectionManager instance;
	 private static Properties props = new Properties();
	public  DBConnectionManager()  throws InvalidEmployeeNumberException, FileNotFoundException
	{
		//FILL THE CODE HERE
		try {
			FileInputStream fis=null;
			fis = new FileInputStream("database.properties");
			props.load(fis);

			Class.forName(props.getProperty("DB_DRIVER_CLASS"));

			con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
			
			
		}
		catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}
		 
		
	}
	public static DBConnectionManager getInstance() throws InvalidEmployeeNumberException, SQLException {
		instance = (DBConnectionManager) DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
			
		return instance;
	}
	public static Connection getConnection() throws InvalidEmployeeNumberException, FileNotFoundException, SQLException {
		instance=new DBConnectionManager();
		//instance.getInstance();
		return con;
	}
}
