package com.dgstory.a220614.test02;
public class EmployeeTest {
	
	public static void main(String[] args) {
		Employee e  = new Employee();
		e.setName("유비");
		e.setSalary(1000.0);
		e.setBirthDate(new MyDate(10, 4, 2000));
		
		Employee e2  = new Employee();
		e2.setName("유비");
		e2.setSalary(1000.0);
		e2.setBirthDate(new MyDate(10, 4, 2000));
		
		System.out.println(e==e2);
		System.out.println(e.equals(e2));	
	}
}
