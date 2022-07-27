package com.dgstory.a220616.test02;

public class Libary {
	private static Libary lb = new Libary();
	private Book[] book;
	int size = 100;
	
	private Libary() {
		this.book = new Book[size];
	}
	public static Libary getLibary() {
		return lb;
	}
	
	public void addBook(Book book) {
		int cnt = 0;
		for(int i =0; i<this.book.length; i++) {
			if(this.book[i] != null) {
				cnt++;
			}
		}
		if(cnt == size - 1) {
			size = size * 2;
			Book[] book2 = new Book[size];
			for(int i = 0; i<this.book.length; i++) {
				this.book[i] = book2[i];
			}
			this.book = book2;
		}
		
		for(int i = 0; i<this.book.length; i++) {			
			if(this.book[i] == null) {
				this.book[i] = book;
				break;
			}
		}
	}
	
	public String getBook(int serial) {
		for (int i = 0; i< this.book.length; i++) {
			if(this.book[i] != null) {
//				System.out.println(this.book[i].getSerial());
				if (this.book[i].getSerial() == serial) {
					return this.book[i].getName();
				}
			}
		}
		return "해당 책이 존재하지 않습니다.";
	}
	
	public void printBook() {
		for(int i = 0; i<this.book.length; i++) {			
			if(this.book[i] != null) {
				System.out.println(i + "//" + book[i].getName() +" // " + book[i].getSerial() );
			}
		}
	}
}
