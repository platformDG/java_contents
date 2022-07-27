package com.dgstory.a220616.test02;

public class MainTest {
	public static void main(String[] args) {
		Libary lb = Libary.getLibary();
		for(int i=0; i<58; i++) {
			lb.addBook(new Book("JAVA 다잡아라"+ i , i));	
		}
		System.out.println(lb.getBook(150));
//		lb.printBook();
	}
}
