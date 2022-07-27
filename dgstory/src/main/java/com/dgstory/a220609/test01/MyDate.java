package com.dgstory.a220609.test01;

public class MyDate {
	private int year;
	private int month;
	private int day;
	public MyDate(MyDate newDate) {
		this.year = newDate.year;
		this.month = newDate.month;
		this.day = newDate.day;
	}
	public MyDate(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public String toString() {
		return "day="+ day + " month="+ month + " year="+ year;
	}
	public MyDate addDays(int moreDays) {
		MyDate newDate = new MyDate(this);
		newDate.day = newDate.day + moreDays;
		return newDate;
	}
}