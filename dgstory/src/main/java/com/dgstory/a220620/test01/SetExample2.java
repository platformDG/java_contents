package com.dgstory.a220620.test01;

import java.util.*;

public class SetExample2 {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second"); //String 풀링에서 동일 값으로 판단
		set.add(new Integer(4));
		System.out.println(set);
	}
}
