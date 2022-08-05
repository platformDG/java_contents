package com.dg.cafe.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Cart {
	private List<LineItem> lineItemList;
	private double totalPrice;
	
	public Cart() {
		lineItemList = new ArrayList<LineItem>();
	}
	
	public void deleteCart() {
		lineItemList = new ArrayList<LineItem>();
		totalPrice = 0.0;
	}
}
