package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

public class MenuItemServiceImpl implements MenuItemService {
	List<MenuItem> mList = new ArrayList<MenuItem>();
	
	@Override
	public void addMenuItem(String name, int price) {
		MenuItem m = new MenuItem(name, price);
		mList.add(m);
	}

	@Override
	public List<MenuItem> getMenuItemList() {
		return mList;
	}

	@Override
	public MenuItem searchMenuItem(String name) {
		for (MenuItem mi : mList) {
			if(mi.getMenuName().equals(name)) {
				return mi;
			}
		}
		return null;
	}
}
