package com.varxyz.jvx330.di.example2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Date {
	private int year;
	private int month;
	private int day;
	
	public String toString() {
		return year +"-" + month +"-" + day;
	}
	
	public int hashCode() {
		return (day ^ month ^ year);
	}
}
