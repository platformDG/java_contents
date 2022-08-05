package com.dg.cafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.cafe.domain.Category;


public class CategoryRowMapper implements RowMapper<Category>{
	
	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category c = new Category();
		c.setCid(rs.getLong("cid"));
		c.setCategoryName(rs.getString("categoryName"));
		c.setSubCategoryName(rs.getString("subCategoryName"));
		c.setRegDate(rs.getTimestamp("regDate"));
	
		return c;
	}
}
