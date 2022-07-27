package com.dgstory.a220614.test02;

public class Employee {
	protected String name="";
	protected double salary;
	protected MyDate birthDate;
	
	public String getDetails() {
		return "Name : " + name + "\nSalary : " + salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}

	public boolean equals(Object o) {
		if(o instanceof Employee ) {
			Employee e = (Employee) o;
			if(e.getName().equals(this.name) && e.getBirthDate().equals(this.birthDate)) {
				return true;
			}
		}
		return false;
	}
}
