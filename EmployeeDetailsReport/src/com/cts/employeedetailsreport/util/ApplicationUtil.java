package com.cts.employeedetailsreport.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.service.HospitalManagement;

public class ApplicationUtil {
	 public static List<String> readFile(String filePath) throws IOException 
	    {
	    	List<String> employeeList=new ArrayList<String>();
	    	
			// FILL THE CODE HERE
	    	try {
	    		FileReader fr = new FileReader(new File(filePath));
				BufferedReader br = new BufferedReader(fr);
				String str;
				while((str = br.readLine()) != null) {
					employeeList.add(str);
					
				}
				HospitalManagement.buildEmployeeList(employeeList);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}
	    	
	    	
	    	return employeeList;
	    	
	    }
	    public static boolean validate(String employeeNumber) throws InvalidEmployeeNumberException
		{
	    	boolean val=false;
			// FILL THE CODE HERE
//			if(employeeNumber.substring(0, 2).equals("PR") && employeeNumber.length() == 7){
//				val = true;
//			}
//			else {
//				throw new InvalidEmployeeNumberException("Invalid Employee Number");
//			}
	    	
	    	int len = employeeNumber.length();
	    	char ch[] = employeeNumber.toCharArray();
	    	if(len == 7) {
	    		if(ch[0] == 'P' && ch[1] == 'R') {
	    			for(int i=2;i<len;i++) {
	    	    		if(Character.isDigit(ch[i])) {
	    	    			val = true;
	    	    		}
	    	    	}
		    	} 
	    	}
	    	else {
	    		throw new InvalidEmployeeNumberException("Invalid Employee Number");
	    	}
	    	
	    	return val;
	    	
	    		

		}


}
