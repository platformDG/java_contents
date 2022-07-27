package com.dgstory.a220614.test02;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public boolean equals(Object o) {
		if(o instanceof MyDate ) {
			MyDate d = (MyDate) o;
			if(d.year == this.year && d.month == this.month && d.day == this.day) {
				return true;
			}
		}
		return false;
	}
}
