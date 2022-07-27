package com.dgstory.a220613.test03;

public class Manager extends Employee {
	protected String department;
	
	public String getDetails() {
		return super.getDetails()+"\nDepartment : " + department;
	}
}
