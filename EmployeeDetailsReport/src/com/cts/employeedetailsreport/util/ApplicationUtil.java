package com.cts.employeedetailsreport.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.model.EmployeeDetails;
import com.cts.employeedetailsreport.service.HospitalManagement;

public class ApplicationUtil {
	 public static List<String> readFile(String filePath) throws IOException 
	    {
	    	List<String> employeeList=new ArrayList<String>();
	    	
			// FILL THE CODE HERE
//			FileReader fr = new FileReader(new File(filePath));
//			BufferedReader br = new BufferedReader(fr);
//			String str;
//			while((str = br.readLine()) != null){
//				String[] sp = str.split(",");
//				String employeeNumber = sp[0];
//				try {
//					if(validate(employeeNumber)){
//						EmployeeDetails emp = new EmployeeDetails();
//						emp.setEmployeeNumber(sp[0]);
//						emp.setEmployeeName(sp[1]);
//						emp.setLevel(sp[2]);
//						emp.setExtraWorkingHours(Integer.parseInt(sp[3]));
//						
//						
//						HospitalManagement.calculateTotalSalary(sp[2], Integer.parseInt(sp[3]));
//						HospitalManagement.buildEmployeeList(employeeList);
//						employeeList.add("emp");
//					}
//				} 
//				catch (InvalidEmployeeNumberException e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			br.close();
	    	try {
	    		FileReader fr = new FileReader(new File(filePath));
				BufferedReader br = new BufferedReader(fr);
				String str;
				while((str = br.readLine()) != null) {
					employeeList.add(str);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	
	    	return employeeList;
	    	
	    }
	    public static boolean validate(String employeeNumber) throws InvalidEmployeeNumberException
		{
	    	boolean val=false;
			// FILL THE CODE HERE
//			if(employeeNumber.substring(0, 2).equals("PR") && employeeNumber.substring(2, 7).length() == 5 && employeeNumber.length() == 7){
//				val = true;
//			}
	    	
	    	int len = employeeNumber.length();
	    	char ch[] = employeeNumber.toCharArray();
	    	if(len != 7) {
	    		throw new InvalidEmployeeNumberException("Invalid Employee Number");
	    	}
	    	if(ch[0] != 'P' && ch[1] != 'R') {
	    		throw new InvalidEmployeeNumberException("Invalid Employee Number");
	    	}
	    	for(int i=2;i<len;i++) {
	    		if(!Character.isDigit(ch[i])) {
	    			throw new InvalidEmployeeNumberException("Invalid Employee Number");
	    		}
	    	}
	    	val = true;
	    	return val;
	    	
	    		

		}


}
