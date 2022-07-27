package com.dgstory.a220613.test01;

public class ArrayConfirm {
	private int[] nums;
	private int[] target;
	
	public ArrayConfirm(int[] nums, int[] target) {
		this.nums = nums;
		this.target = target;
	}
	
	public String confirm() {
		int cnt = 0;
		
		for(int i= 0; i<target.length; i++) {
			for(int j = 0; j<nums.length; j++) {
				if(target[i] == nums[j]) {
					cnt++;
				}
			}
		}
		if(target.length == cnt) {
			return "True";
		}
		else {
			return "False";
		}
		
	}
	
}
