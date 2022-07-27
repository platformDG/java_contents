package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemController {
	
	@Autowired
	private MenuItemService service;
	
	private MenuItemController() {
		System.out.println("MenuItemController 생성");
	}
	
	public void addMenu(String name, int price) {
		service.addMenuItem(name, price);
	}
	
	public List<MenuItem> getMenuItemList() {
		return service.getMenuItemList();
	}
	
	public MenuItem searchMenuItem(String item) {
		return service.searchMenuItem(item);
	}
}
