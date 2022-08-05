package com.dg.cafe.service;

import com.dg.cafe.domain.MenuItem;
import com.dg.cafe.domain.OrderList;

public interface CartService {
	void addLineItem(MenuItem menuItem, int amount);	
	void calcPrice();
	void deleteLineItem(String menuName);
	void changeAmount(String menuName, String flag);
	void addOrderList();
	OrderList getOrderList();
}
