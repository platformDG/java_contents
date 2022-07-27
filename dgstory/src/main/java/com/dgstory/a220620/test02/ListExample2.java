package com.dgstory.a220620.test02;

import java.util.*;

public class ListExample2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("박");
		list.add("동");
		list.add("근");
		list.add("ㅎ");
		System.out.println(list);
		
		for(String s : list) {
			System.out.print(s);
		}
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
