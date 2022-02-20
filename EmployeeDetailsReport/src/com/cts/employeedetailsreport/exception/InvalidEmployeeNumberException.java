package com.cts.employeedetailsreport.exception;

public class InvalidEmployeeNumberException extends Exception 
{

	String strMsg1;
	Throwable strMsg2;
	
	
	public InvalidEmployeeNumberException() {
		super();
	}
	public InvalidEmployeeNumberException(String strMsg1)
	{
		super(strMsg1);
	}
	
	public InvalidEmployeeNumberException(String strMsg1, Throwable strMsg2) {
		super();
		this.strMsg1 = strMsg1;
		this.strMsg2 = strMsg2;
	}
}