package com.dgstory.a220622.test01;

import java.sql.*;

public class JDBCExample2 {
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
			
			String sql = "SELECT * FROM Customer where name = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,"유비");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long cid = rs.getLong("cid");
				String customerid = rs.getString("customerid");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				System.out.println(cid+" / "+customerid+" / "+ name + " / " + phone);
			}
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
