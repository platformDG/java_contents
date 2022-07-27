package com.varxyz.jvx330.di.example7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenuItemDao itemDao;
	
	public void addMenuItem(MenuItem item) {
		itemDao.save(item);
	}
	
	public List<MenuItem> getAllMenuItemList(){
		return itemDao.findAllMenuItemList();
	}
	
	public MenuItem getMenuItem(String menu) {
		return itemDao.findByName(menu);
	}
}
