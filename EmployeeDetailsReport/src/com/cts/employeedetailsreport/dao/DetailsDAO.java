package com.cts.employeedetailsreport.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;

public class DetailsDAO {
 	 
	
	public boolean insertEmployeeList(List <EmployeeDetails> eList) throws InvalidEmployeeNumberException, FileNotFoundException, SQLException {
	
		boolean recordsAdded = false;
		DBConnectionManager db = new DBConnectionManager();
		DBConnectionManager.getInstance();
		Connection conn = db.getConnection();
		conn.setAutoCommit(false);
//		String SQL = "";
		try {
			Statement stmt = conn.createStatement();
			for(EmployeeDetails list: eList) {
				 String SQL = "INSERT INTO EMPDETAILS VALUES('"+list.getEmployeeNumber()+"','"+list.getEmployeeName()+"','"+list.getLevel()+"','"+list.getExtraWorkingHours()+"','"+list.getTotalSalary()+"')";
				 stmt.executeUpdate(SQL);
				 
			}
			
			conn.commit();
			recordsAdded = true;
          
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		
		return recordsAdded;
	}
	    		
	    
	    	
}
