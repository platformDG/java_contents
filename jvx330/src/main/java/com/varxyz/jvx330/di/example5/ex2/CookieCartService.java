package com.varxyz.jvx330.di.example5.ex2;

public class CookieCartService implements CartService {
	@Override
	public void addTime() {
		System.out.println("CookieCartService : addTime() is called");
	}
}
