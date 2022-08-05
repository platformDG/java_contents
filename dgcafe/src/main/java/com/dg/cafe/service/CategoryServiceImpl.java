package com.dg.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.cafe.command.CategoryCommand;
import com.dg.cafe.dao.CategoryDao;
import com.dg.cafe.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void addCategory(CategoryCommand categoryCommand) {
		Category category = new Category();
		category.setCategoryName(categoryCommand.getCategoryName());
		category.setSubCategoryName(categoryCommand.getSubCategoryName());
		categoryDao.addAccount(category);
	}
	
	@Override
	public List<Category> findAllCategory(){
		List<Category> list = categoryDao.findAllCategory();
		return list;
	}
	
	@Override
	public Category findCategoryByCid(long cid) {
		return categoryDao.findCategoryByCid(cid);
	}
	
	@Override
	public long checkCategory(String mainCategory, String subCategory) {
		return categoryDao.getCategoryCid(mainCategory, subCategory);
	}
	 
}
