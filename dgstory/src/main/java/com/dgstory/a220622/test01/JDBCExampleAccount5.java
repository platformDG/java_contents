package com.dgstory.a220622.test01;

import java.sql.*;

public class JDBCExampleAccount5 {
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
			
			String sql = "DELETE FROM Account WHERE aid=?";
			stmt = con.prepareStatement(sql);
			stmt.setLong(1,3002);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
