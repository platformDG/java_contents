package com.dg.cafe.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.dg.cafe.dao.MenuItemDao;
import com.dg.cafe.domain.Category;
import com.dg.cafe.domain.MenuItem;


@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@Autowired 
	ServletContext servletContext;
	
	@Override
	public List<MenuItem> FindAllMenuItem() {
		List<MenuItem> list = menuItemDao.FindAllMenuItem();
		for(MenuItem m : list) {
			m.setCategory(categoryService.findCategoryByCid(m.getCategory().getCid()));
		}
		return list;
	}
	
	@Override
	public List<MenuItem> FindMenuItemByCid(long cid) {
		List<MenuItem> list = menuItemDao.FindMenuItemByCid(cid);
		for(MenuItem m : list) {
			m.setCategory(categoryService.findCategoryByCid(m.getCategory().getCid()));
		}
		return list;
	}
	
	@Override
	public MenuItem getMenuItemByMid(long mid) {
		MenuItem menuItem = menuItemDao.getMenuItemByCid(mid);
		menuItem.setCategory(categoryService.findCategoryByCid(menuItem.getCategory().getCid()));
		return menuItem;
	}
	
	@Override
	public boolean addMenuItem(String categoryName, String subCategoryName, String menuItemName, double menuPrice, MultipartFile file) {
		long cid = categoryService.checkCategory(categoryName, subCategoryName);
		String saveDir = servletContext.getRealPath("/resources/image");
		
		if(cid > 0) {
			MenuItem menuItem = new MenuItem();
			menuItem.setCategory(new Category(cid));
			menuItem.setMenuName(menuItemName);
			menuItem.setMenuPrice(menuPrice);
			menuItem.setImageURL(saveDir);
			menuItem.setImageName(file.getOriginalFilename());
			try {
				uploadImage(file, saveDir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			menuItemDao.addMenuItem(menuItem);
			return true;
		}
		else {
			return false;
		}
	}
	
    public void uploadImage(MultipartFile image, String saveDir) throws IllegalStateException, IOException  {
    //	System.out.println(saveDir);
    	File folder = new File(saveDir);
        if (!folder.exists()) folder.mkdirs();

        File destination = new File(folder.getPath() + File.separator + image.getOriginalFilename());
        image.transferTo(destination);
    }
}
