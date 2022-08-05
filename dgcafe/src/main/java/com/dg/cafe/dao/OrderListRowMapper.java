package com.dg.cafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.cafe.domain.Category;
import com.dg.cafe.domain.OrderList;


public class OrderListRowMapper implements RowMapper<OrderList>{
	
	@Override
	public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderList o = new OrderList();
		o.setOid(rs.getLong("oid"));
		o.setOrderName(rs.getString("orderName"));
		o.setOrderPrice(rs.getDouble("orderPrice"));
		o.setRegDate(rs.getTimestamp("regDate"));
	
		return o;
	}
}
