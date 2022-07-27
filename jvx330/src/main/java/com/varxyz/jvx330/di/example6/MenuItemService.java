package com.varxyz.jvx330.di.example6;

import java.util.List;

public interface MenuItemService {
	void addMenuItem(String name, int price);
	List<MenuItem> getMenuItemList();
	MenuItem searchMenuItem(String name);
}
