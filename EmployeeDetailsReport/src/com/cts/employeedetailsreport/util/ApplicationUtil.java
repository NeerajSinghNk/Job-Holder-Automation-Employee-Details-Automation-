package com.cts.employeedetailsreport.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeedetailsreport.exception.InvalidEmployeeNumberException;
import com.cts.employeedetailsreport.service.HospitalManagement;

public class ApplicationUtil {
	 public static List<String> readFile(String filePath) throws InvalidEmployeeNumberException
	    {
	    	List<String> employeeList=new ArrayList<>();

			// FILL THE CODE HERE
	    	try(BufferedReader in = new BufferedReader(new FileReader(filePath))) {
			    String str;
			    while ((str = in.readLine()) != null) {
			      
			        String[] tokens = str.split(",");
			        String vemp = tokens[0].toString();
			       boolean check= validate(vemp);
			       if(check==true)
			       {
			    	int sal=  (int) HospitalManagement.calculateTotalSalary(tokens[2].toString(),Integer.parseInt(tokens[3]));
			      str=str+","+sal;
			      employeeList.add(str);
			       }
			    }
			}
			catch (IOException e) {
			    System.out.println(e);
			}

	    	return employeeList;

	    }
	    public static boolean validate(String employeeNumber) throws InvalidEmployeeNumberException
		{
	    	boolean val=false;
			// FILL THE CODE HERE
			    int len=	employeeNumber.length();
			    String pr=employeeNumber.substring(0,2);
			    if((pr.equals("PR") && len==7))
			    	val=true;
			    else if(pr.equals("TR"))
			    	val=false;
			   
	    	return val;



		}


}
