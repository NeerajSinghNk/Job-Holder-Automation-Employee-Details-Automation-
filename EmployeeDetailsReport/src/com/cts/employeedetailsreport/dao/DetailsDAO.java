package com.cts.employeedetailsreport.dao;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DetailsDAO {
 	
	
	public static boolean insertEmployeeList(List <EmployeeDetails> eList) throws InvalidEmployeeNumberException {
	
		boolean recordsAdded = false;
		


		try {
			Connection conn = DBConnectionManager.getConnection();
            PreparedStatement stmt;
            int count = 0;

			for(EmployeeDetails emp: eList){

				stmt = conn.prepareStatement("INSERT INTO empdetails(employeeNumber,employeeName,level,extraWorkingHours,totalSalary) VALUES (?,?,?,?,?)");
				stmt.setString(1,emp.getEmployeeNumber());
				stmt.setString(2,emp.getEmployeeName());
				stmt.setString(3, emp.getLevel());
				stmt.setInt(4, emp.getExtraWorkingHours());
				stmt.setDouble(5, emp.getTotalSalary());
				count = stmt.executeUpdate();
				if(count != 0){
					recordsAdded = true;

				}
			}
		} 
		catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}


		return recordsAdded;
	}



}