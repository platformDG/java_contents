package com.dgstory.a220610.test04;
/**
 * 임의의 10진수를 입력하여 2진수로 변환하는 프로그램
 */
public class DecimalToBinary {
	public static void main(String[] args) {
		int number = 100; // 입력값.
		int data; // 절대값으로 치환하기 위한 변수
		int[] num = new int[100]; //2진수를 담을 공간
		int i = 0; 
		String binaryStr ="";
		
		//절대값으로 계산하기 위해 변경
		if(number < 0) {
			data = number * -1;
		}
		else {
			data = number;
		}
		//정수를 2로 나눠서 2진수값을 num배열에 대입
		while( data/2 != 0 ) {
			num[i] = data % 2;
			i++;			
			data = data/2;
		}
		
		//입력한값을 반대로 문자열로 치환
		for(int j=i; j>=0; j--) {
			binaryStr = binaryStr + Integer.toString(num[j]);
		}
		
		for (int k=i+1; k<31; k++) {
			binaryStr= "0" + binaryStr;
		}
		// 맨앞자리 부호		
		if(number > 0) {
			binaryStr = "0" + binaryStr;
		}
		else {
			binaryStr = "1" + binaryStr;
		}
		System.out.println("입력값 : " + number);
		System.out.println("2진수 : " + binaryStr);	
	}
}