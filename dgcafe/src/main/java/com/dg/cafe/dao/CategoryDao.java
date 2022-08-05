package com.dg.cafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dg.cafe.domain.Category;

@Repository("categoryDao")
public class CategoryDao {

	private JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Category category) {
		String sql = "INSERT INTO Category (categoryName, subCategoryName) VALUES (?,?)";
		jdbcTemplate.update(sql, category.getCategoryName(), category.getSubCategoryName());
	}
	
	public List<Category> findAllCategory(){
		String sql = "SELECT * FROM Category";
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}
	
	public Category findCategoryByCid(long cid) {
		String sql = "SELECT * FROM Category WHERE cid = ?";
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), cid);
	}
	
	public long getCategoryCid(String mainCategory, String subCategory) {
		String sql = "SELECT cid FROM Category WHERE categoryName = ? AND subCategoryName = ?";
		return jdbcTemplate.queryForObject(sql, Long.class, mainCategory, subCategory);
	}
}
