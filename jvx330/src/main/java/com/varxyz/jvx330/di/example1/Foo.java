package com.varxyz.jvx330.di.example1;

public class Foo {
	private Bar bar;
	
	public Foo() {
		System.out.println("Foo() Constructor is called");
	}
	
	public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) Constructor is called");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() is called");
		
	}
	public String toString() {
		return "[Foo : " + hashCode() +"]";
	}
}
