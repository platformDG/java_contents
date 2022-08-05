package com.dg.cafe.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.dg.cafe.domain.MenuItem;

public interface MenuItemService {
	 List<MenuItem> FindAllMenuItem();
	 List<MenuItem> FindMenuItemByCid(long cid);
	 MenuItem getMenuItemByMid(long mid);
	 boolean addMenuItem(String categoryName, String subCategoryName, String menuItemName, double menuPrice, MultipartFile file);
}
