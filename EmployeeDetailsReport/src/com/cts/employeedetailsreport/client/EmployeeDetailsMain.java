package com.cts.employeedetailsreport.client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.employeedetailsreport.dao.DBConnectionManager;
import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.skeleton.SkeletonValidator;
import com.cts.employeedetailsreport.util.ApplicationUtil;

public class EmployeeDetailsMain {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, SQLException, InvalidEmployeeNumberException {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();
		 
		// CODE SKELETON - VALIDATION ENDS

// TYPE YOUR CODE HERE
		DBConnectionManager db = new DBConnectionManager();
		DBConnectionManager.getInstance();
		Connection c = db.getConnection();
		ApplicationUtil au = new ApplicationUtil();
		au.readFile("inputfeed.txt");
		Statement s = c.createStatement();
		String SQL = "Select * from empdetails";
		ResultSet rs = s.executeQuery(SQL);
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
		}
		
	}

	} 

