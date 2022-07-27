package com.varxyz.banking.dao;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.domain.Customer;

@Repository("customerDao")
public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userid, passwd, name, ssn, phone) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), 
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public List<Customer> findAllCustomer() {
		String sql = "SELECT cid, emuseridail, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate){
		String sql = "SELECT cid, userid, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE DATE(regDate) =? ";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate);
	}
	
	public Customer findCustomerByUserId(String userId) {
		String sql = "SELECT cid, userid, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE userid =? ";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId);
	}
	
	public int findCustomerByUserIdPasswd(String userId, String passwd) {
		String sql = "SELECT count(*) FROM Customer "
				   + "WHERE userid = ? AND passwd = ? ";
		return jdbcTemplate.queryForObject(sql, Integer.class , userId, passwd);
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	public List<Customer> findCustomerByRegDate2(Date regDate, Date regDate2) {
		String sql = "SELECT cid, userid, passwd, name, ssn, phone, regDate FROM Customer "
				   + "WHERE DATE(regDate) BETWEEN ? AND ? ";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate, regDate2);
	}
}
