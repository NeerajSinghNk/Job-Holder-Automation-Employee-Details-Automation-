package com.cts.employeedetailsreport.client;
import java.io.IOException;
import java.sql.SQLException;
import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.service.HospitalManagement;
import com.cts.employeedetailsreport.skeleton.SkeletonValidator;

public class EmployeeDetailsMain {

//	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, SQLException, InvalidEmployeeNumberException {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();
		 
		// CODE SKELETON - VALIDATION ENDS
		HospitalManagement hm=new HospitalManagement();
		hm.addEmployeeList("inputfeed.txt");
	}

	} 

