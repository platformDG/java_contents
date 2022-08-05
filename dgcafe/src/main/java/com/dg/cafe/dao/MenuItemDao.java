package com.dg.cafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dg.cafe.domain.MenuItem;

@Repository
public class MenuItemDao {

	private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<MenuItem> FindAllMenuItem(){
		String sql = "SELECT * FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	public List<MenuItem> FindMenuItemByCid(long cid){
		String sql = "SELECT * FROM MenuItem WHERE categoryID =?";
		return jdbcTemplate.query(sql, new MenuItemRowMapper(), cid);
	}
	
	public MenuItem getMenuItemByCid(long mid) {
		String sql = "SELECT * FROM MenuItem WHERE mid =?";
		return jdbcTemplate.queryForObject(sql, new MenuItemRowMapper(), mid);
	}
	
	public void addMenuItem(MenuItem menuitem) {
		String sql = "INSERT INTO MenuItem (categoryID, menuName, menuPrice, imageURL, imageName) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, menuitem.getCategory().getCid(), menuitem.getMenuName(), menuitem.getMenuPrice(), menuitem.getImageURL(), menuitem.getImageName());
	}
}
