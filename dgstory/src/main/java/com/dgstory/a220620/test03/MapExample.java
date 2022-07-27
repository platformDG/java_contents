package com.dgstory.a220620.test03;

import java.util.*;

public class MapExample {
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(Integer.valueOf(1), "유비");
		map.put(2, "관우"); // 자동으로 바꿔준다. : 오토박싱
		map.put(new Integer(3), "장비");
		
		System.out.println(map.get(2));
		
		Set<Integer> set = map.keySet();
		for(Integer integer : set) {
			System.out.print(integer);
			System.out.println(" = " + map.get(integer));
		}
	}
}
