package com.dg.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.cafe.dao.CartDao;
import com.dg.cafe.domain.Cart;
import com.dg.cafe.domain.LineItem;
import com.dg.cafe.domain.MenuItem;
import com.dg.cafe.domain.OrderList;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private Cart cart;
	@Autowired
	private CartDao cartDao;
	
	private LineItem lineItem;
	
	@Override
	public void addLineItem(MenuItem menuItem, int amount) {
		
		//주문 카트에 같은 이름이 있는지 체크하기
		boolean flag = true;
		for(LineItem li : cart.getLineItemList()) {
			if(li.getMenuItem().getMenuName().equals(menuItem.getMenuName())) {
				flag = false;
				li.setAmount(li.getAmount() + 1);
				calcPrice();
			}
		} 
		
		if(flag == true) { 
			lineItem = new LineItem();
			double price = menuItem.getMenuPrice() * amount;
			lineItem.setMenuItem(menuItem);
			lineItem.setAmount(amount);
			lineItem.setLineItemPrice(price);
			cart.getLineItemList().add(lineItem);
			calcPrice();
		}
	}
	
	@Override
	public void calcPrice() {
		double totalPrice = 0;
		for(LineItem li : cart.getLineItemList()) {
			totalPrice += li.getMenuItem().getMenuPrice() * li.getAmount();
		}
		cart.setTotalPrice(totalPrice);
	}
	
	public void deleteLineItem(String menuName) {
		for(int i=0; i < cart.getLineItemList().size(); i++) {
			if(cart.getLineItemList().get(i).getMenuItem().getMenuName().equals(menuName)) {
				cart.getLineItemList().remove(i);
			}
		}
		calcPrice();
	}
	
	@Override
	public void changeAmount(String menuName, String flag) {
		for(int i=0; i < cart.getLineItemList().size(); i++) {
			if(cart.getLineItemList().get(i).getMenuItem().getMenuName().equals(menuName)) {
				if(flag.equals("plus")) {
					cart.getLineItemList().get(i).setAmount(cart.getLineItemList().get(i).getAmount() + 1);
				}
				else {
					if(cart.getLineItemList().get(i).getAmount() != 0) {
						cart.getLineItemList().get(i).setAmount(cart.getLineItemList().get(i).getAmount() - 1);
					}
					else{
						cart.getLineItemList().get(i).setAmount(0);
					}
				}
			}
		}
		calcPrice();
	}
	@Override
	public void addOrderList() {
		cartDao.addOrderList(cart);
	}
	@Override
	public OrderList getOrderList() {
		return cartDao.getOrderList();
	}
	
	public Cart getCart() {
		return cart;
	}
}
