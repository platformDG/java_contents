package com.dgstory.a220613.test02;
/**
 * 이모티콘를 난수를 발생해서 가져오기
 * 동그라미 70%, 삼각형 50%, 사각형 30%, 오각형 5%, 육각형 1%, 삼각형 0.1%
 */
public class Emoticon {
	public static void main(String[] args) {
		EmoticonCtrl ec = new EmoticonCtrl();
		System.out.println(ec.getEmoticon());
	}
}
