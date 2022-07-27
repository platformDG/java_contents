package com.dgstory.a220616.test01;

public class Airplane implements Flyer, Vehicle {

	public void fly() {
		System.out.println("비행기 : 날기");
	}

	public void takeOff() {
		System.out.println("비행기 : 이륙");
	}

	public void land() {
		System.out.println("비행기 : 착륙");
	}
	
}
