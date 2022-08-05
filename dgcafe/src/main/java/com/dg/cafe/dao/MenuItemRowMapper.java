package com.dg.cafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.cafe.domain.Category;
import com.dg.cafe.domain.MenuItem;

public class MenuItemRowMapper implements RowMapper<MenuItem>{
	
	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem m = new MenuItem();
		m.setMid(rs.getLong("mid"));
		m.setCategory(new Category(rs.getLong("categoryId")));
		m.setMenuName(rs.getString("menuName"));
		m.setMenuPrice(rs.getDouble("menuPrice"));
		m.setImageURL(rs.getString("imageURL"));
		m.setImageName(rs.getString("imageName"));
		m.setRegDate(rs.getTimestamp("regDate"));
		return m;
	}
}
