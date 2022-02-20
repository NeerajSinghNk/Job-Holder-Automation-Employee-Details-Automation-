package com.cts.employeedetailsreport.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;
import com.cts.employeedetailsreport.util.ApplicationUtil;

public class HospitalManagement {
	
private List<String> employeeRecords;
public List<String> getEmployeeRecords(){
	return employeeRecords;
}
public void setEmployeeRecords(List<String> employeeRecords) {
	this.employeeRecords = employeeRecords;
}
	
public static ArrayList <EmployeeDetails> buildEmployeeList(List <String> employeeRecords) {
		
		
		final String COMMADELIMITER = ",";
		ArrayList <EmployeeDetails> empList = new ArrayList<EmployeeDetails>();
		
    	//fill the code here
		int listSize = employeeRecords.size();
		int i=0;
		EmployeeDetails empDt;
		while(listSize-- > 0) {
			String employeeDetailsString[] = employeeRecords.get(i++).split(COMMADELIMITER);
			try {
				if(ApplicationUtil.validate(employeeDetailsString[0])) {
					int extraHours = Integer.parseInt(employeeDetailsString[3]);
					double sal = calculateTotalSalary(employeeDetailsString[2], extraHours);
					empDt = new EmployeeDetails(employeeDetailsString[0],employeeDetailsString[1],employeeDetailsString[2],extraHours,sal);
					empList.add(empDt);
				}
			} catch (InvalidEmployeeNumberException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
 	 	
		return empList;
	}
	
	
	
	public boolean addEmployeeList(String inputFeed) throws InvalidEmployeeNumberException, IOException
	{
    	//fill the code here
		try {
			this.setEmployeeRecords(ApplicationUtil.readFile(inputFeed));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	

	public static double calculateTotalSalary(String level,int extraWorkingHours)
    {
		double sal=0.0;
    	//fill the code here
		if(level.equals("level1")){
			sal = 75000 + (extraWorkingHours * 1000);
		}
		if(level.equals("level2")){
			sal = 50000 + (extraWorkingHours * 1000);
		}
		if(level.equals("level3")){
			sal = 35000 + (extraWorkingHours * 1000);
		}
		if(level.equals("level4")){
			sal = 25000 + (extraWorkingHours * 1000);
		}

		return sal;
    }
    

}
 