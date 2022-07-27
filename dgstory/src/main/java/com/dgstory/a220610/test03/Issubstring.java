package com.dgstory.a220610.test03;
/**
 * 하나의 문자열에서 특정 단어가 포함되어 있는지 확인해보는 프로그램
 */
public class Issubstring {
	
	public static void main(String[] args) {
		String text = "The cat in the hat";
		boolean tf = isSubString("hat",text);
		System.out.println(tf);
	}
	
	public static boolean isSubString(String item, String line) {
		int itemL = item.length();
		int lineL = line.length();
		int cnt = 0;
		for(int i = 0; i < lineL; i++) {
			if(item.charAt(0) == line.charAt(i)) {
				cnt = 0;
				for(int j= 0; j<itemL; j++) {
					if(i+j < lineL) {
						if(item.charAt(j) == line.charAt(i+j)) {
							cnt++;
						}
					}
				}
			}
		}
		if (itemL == cnt) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
