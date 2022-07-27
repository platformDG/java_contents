package com.dgstory.a220613.test02;
import java.util.Random;
public class EmoticonCtrl {
	String[] emoti;
	public EmoticonCtrl() {
		this.emoti = new String[1566];
		for(int i = 0; i< 1566; i++) {
			if(i >= 0 && i < 700) {
				emoti[i] = "동그라미";
			}
			else if(i>=700 && i< 1200) {
				emoti[i] = "삼각형";
			}
			else if(i>=1200 && i< 1500) {
				emoti[i] = "사각형";
			}
			else if(i>=1500 && i< 1550) {
				emoti[i] = "오각형";
			}
			else if(i>=1550 && i< 1560) {
				emoti[i] = "육각형";
			}
			else if(i>=1560 && i< 1565) {
				emoti[i] = "삼각형";
			}
			else {
				emoti[i] = "별";
			}
		}
	}
	
	public String getEmoticon() {
		Random rd = new Random();
		return emoti[rd.nextInt(1566)];
	}
}
