package com.varxyz.jv300.mod011;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	public UserDao() {
		
	}
	public boolean isValidUser(String userId, String passwd) {
		String sql = "SELECT * FROM userinfo WHERE userid = ? and passwd = ?";
		int i = 0;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,userId);
				pstmt.setString(2,passwd);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					i++;
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {  
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO UserInfo(userid, passwd, username, ssn, email, addr )  VAlUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUserId());
			pstmt.setString(2,user.getPasswd());
			pstmt.setString(3,user.getUserName());
			pstmt.setString(4,user.getSsn());
			pstmt.setString(5,user.getEmail());
			pstmt.setString(6,user.getAddr());
			pstmt.executeUpdate();
			ds.close(pstmt, con);
			System.out.println("INSERTED....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findAllUsers(){	
		String sql = "SELECT * FROM userinfo";
		List<User> customerList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User c = new User();
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					c.setUserName(rs.getString("username"));
					c.setSsn(rs.getString("ssn"));
					c.setEmail(rs.getString("email"));
					c.setAddr(rs.getString("addr"));
					customerList.add(c);
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public User findUserByName(String ssn){
		String sql = "SELECT * FROM UserInfo WHERE username = ?";
		User c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = new User();
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					c.setUserName(rs.getString("username"));
					c.setSsn(rs.getString("ssn"));
					c.setEmail(rs.getString("email"));
					c.setAddr(rs.getString("addr"));
				}

			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public void updateUser(User user) {
		String sql = "UPDATE UserInfo SET passwd =?, username =?, ssn =?, email =?, addr =?  WHERE userid = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getPasswd());
			pstmt.setString(2,user.getUserName());
			pstmt.setString(3,user.getSsn());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getAddr());
			pstmt.setString(6,user.getUserId());
			pstmt.executeUpdate();
			ds.close(pstmt, con);
			System.out.println("UPDATE....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
