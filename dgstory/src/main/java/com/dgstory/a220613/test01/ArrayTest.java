package com.dgstory.a220613.test01;
/**
 * 두개의 배열을 가지고 한개의 배열이 나머지 한개의 배열에 포함이 되는지 확인하는 예제
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] nums = new int[10];
		int[] target = new int[3];
		
		for(int i = 0; i<nums.length; i++) {
			nums[i] = i;
		}
		
		target[0] = 11;
		target[1] = 3;
		target[2] = 5;
		
		ArrayConfirm ac = new ArrayConfirm(nums, target);
		System.out.println(ac.confirm());
	}
}
