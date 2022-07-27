package com.dgstory.a220614.test01;
/**
 * 다형성을 보여주기 위한 프로그램
 */
public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("thinkPad"));
		cart.addProduct(new SmartPhone("Samsung Gallaxy"));
		cart.addProduct(new SmartPhone("Apple Iphone"));
		System.out.println(cart.getProducts()[1].getName());
		System.out.println(cart.getDetails());
	}
}
