package com.dgstory.a220617.test01;

public class PrimeNumberConfirm {
	private static int cnt;
	private static int i;
	private static int[] al = new int[50];
	
	public static boolean checkPrimeNumber(int num) throws NotPrimeNumberException {
		if(num < 2) {
			throw new RuntimeException("숫자는 1보다 커야합니다.");
		}
		cnt = 0;
		for(int j= 1; j<=num; j++) {
			if ( num % j == 0 ) {
				if(j != 1 && j != num) {
					al[i++] = j;
				}
				cnt++;
			}
		}
		if(cnt < 3) {
			return true;
		}
		else {
			int[] primeNumberList = new int[100];
			int p = 0;
			// 1 2 4 5 10 20
			// 1 2 2 2 5 2 5 2 2 5 5
			for (int k = 0; k < i; k++) {
				if(checkPrimeNumber(al[k]) == true) {
					primeNumberList[p++] = al[k];
				}				
				else {
					//
				}
			}
			if (al[0] * al[i-1] == num) {
				 throw new NotPrimeNumberException(num+" 는 "+al[0]+" * "+ al[i-1] +" 으로도 표현이 되기때문에 " +"PrimeNumber가 아닙니다.");
			}
			return false;
		}
	}
	
	public int[] getPrimeNumberList(int num) {
		int[] list = new int[100];
		for(int j= 1; j<=num; j++) {
			if ( num % j == 0 ) {
				if(j != 1 && j != num) {
					al[i++] = j;
				}
			}
		}
		return list;
	}
}
