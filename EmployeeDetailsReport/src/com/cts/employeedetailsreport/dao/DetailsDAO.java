package com.cts.employeedetailsreport.dao;

import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DetailsDAO {


	public boolean insertEmployeeList(List <EmployeeDetails> eList) throws InvalidEmployeeNumberException {

		boolean recordsAdded = false;

		// FILL THE CODE HERE
		try(Connection con = DBConnectionManager.getInstance().getConnection()) {
			for(EmployeeDetails stdAdmObj:eList) {
				String sql = "INSERT INTO empdetails	VALUES(?,?,?,?,?);";
				PreparedStatement prepState = con.prepareStatement(sql);
				prepState.setString(1, stdAdmObj.getEmployeeNumber());
				prepState.setString(2, stdAdmObj.getEmployeeName());
				prepState.setString(3,stdAdmObj.getLevel());
				prepState.setInt(4, stdAdmObj.getExtraWorkingHours());
				prepState.setDouble(5, stdAdmObj.getTotalSalary());
				prepState.execute();
			}
			recordsAdded= true;
		}
	 catch(Exception e) {
		System.out.println(e.getMessage());
		throw new InvalidEmployeeNumberException(e.getMessage(), e.getCause());
		} 
		
		return recordsAdded;
	}



}
