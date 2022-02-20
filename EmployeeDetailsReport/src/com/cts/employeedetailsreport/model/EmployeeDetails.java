package com.cts.employeedetailsreport.model;

public class EmployeeDetails {
	private String employeeNumber;
    private String employeeName;
    private String level;
    private int extraWorkingHours;
    private double totalSalary;
    
     
	
	
//Constructors

	public EmployeeDetails(String string1, String string2, String string3, int i,double sal) {
		this.employeeNumber=string1;
		this.employeeName=string2;
		this.level=string3;
		this.extraWorkingHours=i;
		this.totalSalary=sal;
	}






	public EmployeeDetails() {
	}




//getters and setters

	public String getEmployeeNumber() {
		return employeeNumber;
	}






	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}






	public String getEmployeeName() {
		return employeeName;
	} 






	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}






	public String getLevel() {
		return level;
	}






	public void setLevel(String level) {
		this.level = level;
	}






	public int getExtraWorkingHours() {
		return extraWorkingHours;
	}






	public void setExtraWorkingHours(int extraWorkingHours) {
		this.extraWorkingHours = extraWorkingHours;
	}






	public double getTotalSalary() {
		return totalSalary;
	}






	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}






	@Override
	public String toString() {
		return "EmployeeDetails [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", level="
				+ level + ", extraWorkingHours=" + extraWorkingHours + ", totalSalary=" + totalSalary + "]";
	}
	
	


}
