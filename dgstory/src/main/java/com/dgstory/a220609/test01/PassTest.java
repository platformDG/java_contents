package com.dgstory.a220609.test01;
/**
 * 클래스의 개념과 초기화에 대해서 확인 해보는 예제
 */
public class PassTest {
	public static void changeInt(int value) {
		value = 55;
	}
	public static void changeObjectRef(MyDate ref) {
		ref = new MyDate(1,1,2000);
	}
	public static void changeObjectAttr(MyDate ref) {
		ref.setDay(4);
		
	}
	
	public static void main(String[] args) {
		MyDate date;
		int val;
		val = 11;
		changeInt(val);
		System.out.println("int value is " + val);
		
		date = new MyDate(22, 7, 1964);
		
		changeObjectRef(date);
		System.out.println("MyDate is " + date.toString());
		
		changeObjectAttr(date);
		System.out.println("MyDate is " + date.toString());
	}
}
