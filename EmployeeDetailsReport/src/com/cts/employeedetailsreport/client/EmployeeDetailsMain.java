package com.cts.employeedetailsreport.client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.employeedetailsreport.dao.DBConnectionManager;
import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.service.HospitalManagement;
import com.cts.employeedetailsreport.skeleton.SkeletonValidator;

public class EmployeeDetailsMain {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, SQLException, InvalidEmployeeNumberException {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();
		 
		// CODE SKELETON - VALIDATION ENDS
//		new HospitalManagement();
// TYPE YOUR CODE HERE
		DBConnectionManager db = new DBConnectionManager();
		Connection c = db.getConnection();
		HospitalManagement hm = new HospitalManagement();
		hm.addEmployeeList("inputfeed.txt");
		Statement s = c.createStatement();
		String SQL = "Select * from empdetails";
		ResultSet rs = s.executeQuery(SQL);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		
	}

	} 

