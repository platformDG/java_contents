package com.varxyz.jv250.jdbc;

import java.sql.*;

public class JDBCExample4 {
	public static void main(String[] args) {
		String driver ="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection con = null;
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ----->" + driver);
			
			con =  DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED DRIVER ----->" + url);
			
			String sql = "UPDATE Customer SET phone =?, customerid=? WHERE cid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,"010-6686-1234");
			stmt.setString(2,"mysql");
			stmt.setLong(3,1005);
			
			stmt.executeUpdate();
			
//			while(rs.next()) {
//				long cid = rs.getLong("cid");
//				String customerid = rs.getString("customerid");
//				String name = rs.getString("name");
//				String phone = rs.getString("phone");
//				System.out.println(cid+" / "+customerid+" / "+ name + " / " + phone);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
//				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
