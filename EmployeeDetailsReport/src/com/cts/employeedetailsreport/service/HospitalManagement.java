package com.cts.employeedetailsreport.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;
import com.cts.employeedetailsreport.util.ApplicationUtil;

public class HospitalManagement {


public static ArrayList <EmployeeDetails> buildEmployeeList(List <String> employeeRecords) {


		final String COMMADELIMITER = ",";
		ArrayList <EmployeeDetails> empList = new ArrayList<>();

    	//fill the code here
		  for (String str : employeeRecords)
	      { 		  
			  String[] tokens = str.split(COMMADELIMITER);
			  EmployeeDetails emp=new EmployeeDetails();
			  emp.setEmployeeName(tokens[0].toString());
			  emp.setEmployeeName(tokens[1].toString());
			  emp.setLevel(tokens[2].toString());
			  emp.setExtraWorkingHours(Integer.parseInt(tokens[3].toString()));
			  emp.setTotalSalary(Double.parseDouble(tokens[4].toString()));
			  empList.add(emp);
			  
	      }
		return empList;
	}



	public boolean addEmployeeList(String inputFeed) throws InvalidEmployeeNumberException, IOException
	{
    	//fill the code here
		ApplicationUtil au=new ApplicationUtil();
		List<String> employeeList=new ArrayList<>();
		ArrayList <EmployeeDetails> empList = new ArrayList<>();
		employeeList=	au.readFile(inputFeed);
		empList=buildEmployeeList(employeeList);
		for(String res:employeeList)
		{
			System.out.println(res);
		}
		return false;
	}



	public static double calculateTotalSalary(String level,int extraWorkingHours)
    {
		double sal=0.0;
    	//fill the code here
if(level.equals("level1"))
{
	sal=sal+75000+(extraWorkingHours*1000);
}
else if(level.equals("level2"))
{
	sal=sal+50000+(extraWorkingHours*1000);
}
else if(level.equals("level3"))
{
	sal=sal+35000+(extraWorkingHours*1000);
}
else if(level.equals("level4"))
{
	sal=sal+25000+(extraWorkingHours*1000);
}
		return sal;
    }


}
