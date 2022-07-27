package com.dgstory.a220610.test01;
/**
 * 구구단을 출력하는 프로그램 
 * 단. 단수별로 왼쪽으로 출력되도로 구현
 */
public class MultiplicationTable {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++ ) {
			for(int j = 2; j < 10; j++) {
				int result = i*j;
				System.out.print(j +" * " +i+" = "+result+"\t");
			}
			System.out.println();
		}
	}
}
