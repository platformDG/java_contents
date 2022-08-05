package com.varxyz.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.domain.Customer;

import lombok.Getter;


public class CustomerRowMapper implements RowMapper<Customer>{
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c  = new Customer(rs.getLong("cid"), 
				rs.getString("email"),
				rs.getString("passwd"),
				rs.getString("name"),
				rs.getString("ssn"),
				rs.getString("phone"),
				rs.getDate("regDate")
				);
		return c;
	}
}
