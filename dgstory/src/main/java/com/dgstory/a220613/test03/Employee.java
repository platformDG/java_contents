package com.dgstory.a220613.test03;

import java.util.Date;

public class Employee {
	protected String name="";
	protected double salary;
	protected Date birthDate;
	
	public String getDetails() {
		return "Name : " + name + "\nSalary : " + salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
