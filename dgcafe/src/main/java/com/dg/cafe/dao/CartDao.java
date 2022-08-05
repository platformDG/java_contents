package com.dg.cafe.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dg.cafe.domain.Cart;
import com.dg.cafe.domain.OrderList;


@Repository
public class CartDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CartDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addOrderList(Cart cart) {
		String sql = "INSERT INTO OrderList (orderName, orderPrice) VALUES (?,?)";
		String menuName = cart.getLineItemList().get(0).getMenuItem().getMenuName();
		if(cart.getLineItemList().size() > 0) {
			menuName += " 외 " + (cart.getLineItemList().size() - 1);
		}
		
		jdbcTemplate.update(sql, menuName , cart.getTotalPrice());
	}
	
	public OrderList getOrderList() {
		String sql = "SELECT * FROM OrderList WHERE oid = (select max(oid) from OrderList)";
		return jdbcTemplate.queryForObject(sql, new OrderListRowMapper());
	}
}
