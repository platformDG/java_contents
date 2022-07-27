package com.dgstory.a220613.test03;
import java.util.Date;
public class EmployeeTest {
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "유비";
		e.salary= 1000.0;
		e.birthDate = new Date();
		System.out.println(e.getDetails());
		System.out.println(e.birthDate);
		
		Manager m = new Manager();
		m.department ="영업부";
		m.name = "관우";
		m.salary = 950.5;
		System.out.println(m.getDetails());	
	}
}
