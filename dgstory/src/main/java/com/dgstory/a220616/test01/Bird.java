package com.dgstory.a220616.test01;

public class Bird implements Flyer {
	
	public void fly() {
		System.out.println("새 : 날기");
	}

	public void takeOff() {
		System.out.println("새 : 이륙");
	}

	public void land() {
		System.out.println("새 : 착륙");
	}
}
