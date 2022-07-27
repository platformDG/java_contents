package com.dgstory.a220610.test02;
/**
 * 임의의 정수에서 소수를 찾아내는 프로그램
 */
public class PrimeNumber {
	public static void main(String[] args) {
		int cnt;
		for (int i = 1; i < 1000; i++ ) {
			cnt = 0;
			for(int j= 1; j<=i; j++) {
				if ( i % j == 0 ) {
					cnt++;
				}
			}
			if(cnt < 3) {
				System.out.println(i);
			}
		}
	}
}
