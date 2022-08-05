package com.dg.cafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
	private MenuItem menuItem;
	private int amount;
	private double lineItemPrice;
}
