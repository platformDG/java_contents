package com.varxyz.jvx330.di.example5.ex2;

public class SessionCartService implements CartService {

	@Override
	public void addTime() {
		System.out.println("SessionCartService : addTime() is called");
	}

}
