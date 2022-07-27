package com.dgstory.a220620.test01;

import java.util.*;

public class SetExample {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add("second"); //String 풀링에서 동일 값으로 판단
		System.out.println(set);
	}
}
