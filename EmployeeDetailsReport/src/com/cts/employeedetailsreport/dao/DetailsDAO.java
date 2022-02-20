package com.cts.employeedetailsreport.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;

public class DetailsDAO {
 	 
	
	public boolean insertEmployeeList(List <EmployeeDetails> eList) throws InvalidEmployeeNumberException, FileNotFoundException, SQLException {
	
		boolean recordsAdded = false;
		DBConnectionManager db = new DBConnectionManager();
		// FILL THE CODE HERE
		String SQL = "INSERT INTO empdetails(employeeNumber,employeeName,level,extraWorkingHours,totalSalary) " + "VALUES(?,?,?,?,?)";
		DBConnectionManager.getInstance();
		Connection conn = db.getConnection();
		try {
			
            PreparedStatement stmt = conn.prepareStatement(SQL); 
//            int count = 0;

			for(EmployeeDetails emp: eList){
				stmt.setString(1,emp.getEmployeeNumber());
				stmt.setString(2,emp.getEmployeeName());
				stmt.setString(3, emp.getLevel());
				stmt.setInt(4, emp.getExtraWorkingHours());
				stmt.setDouble(5, emp.getTotalSalary());
				stmt.executeUpdate(SQL);
//				count = stmt.executeUpdate(SQL);
//				if(count != 0){
//					recordsAdded = true;
//				} 
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
