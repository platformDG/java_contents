package com.dgstory.a220614.test02;

public class Manager extends Employee {
	protected String department;
	
	public String getDetails() {
		return super.getDetails()+"\nDepartment : " + department;
	}
}
