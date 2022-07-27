package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	@Autowired
	@Qualifier("sessionCartService")
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService")
	private CartService service2;
	
	private CartController() {
		System.out.println("CartController 생성");
	}
	public void processRequest() {
		service.addTime();
		service2.addTime();
	}
	
}
