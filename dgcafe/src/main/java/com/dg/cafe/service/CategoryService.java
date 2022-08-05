package com.dg.cafe.service;

import java.util.List;

import com.dg.cafe.command.CategoryCommand;
import com.dg.cafe.domain.Category;

public interface CategoryService {
	void addCategory(CategoryCommand categoryCommand);
	List<Category> findAllCategory();
	Category findCategoryByCid(long cid);
	long checkCategory(String mainCategory, String subCategory);
}
