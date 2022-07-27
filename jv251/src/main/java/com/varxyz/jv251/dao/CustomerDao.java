package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Customer;

public class CustomerDao {

	public CustomerDao() {
		
	}
	
	public List<Customer> findAllCustomers(){	
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserID(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					customerList.add(c);
				}
			}finally {
				DataSourceManager.getConnectionClose(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public Customer findCustomerBySsn(String ssn){
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserID(rs.getString("userid"));
					c.setPasswd(rs.getString("passwd"));
				}

			}finally {
				DataSourceManager.getConnectionClose(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 신규 고객 등록
	 * @param customer		등록할 고객정보
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone, userid, passwd) VAlUES (?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = DataSourceManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,customer.getName());
			pstmt.setString(2,customer.getSsn());
			pstmt.setString(3,customer.getPhone());
			pstmt.setString(4,customer.getUserID());
			pstmt.setString(5,customer.getPasswd());
			pstmt.executeUpdate();
			DataSourceManager.getConnectionClose(pstmt, con);
			System.out.println("INSERTED....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
