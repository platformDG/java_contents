package com.varxyz.jvx330.jdbc.example2;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomer() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate){
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE DATE(regDate) =? ";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE email =? ";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email);
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	public List<Customer> findCustomerByRegDate2(Date regDate, Date regDate2) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE DATE(regDate) BETWEEN ? AND ? ";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate, regDate2);
	}
}
