package com.dgstory.a220617.test01;

public class MainTest {
	public static void main(String[] args) {
		boolean bool;
		PrimeNumber pn = new PrimeNumber(100);
		try {
			bool = PrimeNumberConfirm.checkPrimeNumber(pn.getNum());
			if (bool == true) {
				System.out.println("소수입니다.!");
			}
		} catch (NotPrimeNumberException e) {
			System.out.println(e.getMessage());
		}
	}
}