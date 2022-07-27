package com.dgstory.a220616.test02;

public class Book {
	private int serial;
	private String name;
	public Book(String name, int serial) {
		this.name = name;
		this.serial = serial;
	}
	public int getSerial() {
		return serial;
	}
	public String getName() {
		return name;
	}
}
