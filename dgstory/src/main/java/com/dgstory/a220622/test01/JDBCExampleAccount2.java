package com.dgstory.a220622.test01;

import java.sql.*;

public class JDBCExampleAccount2 {
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
			
			String sql = "SELECT * FROM Account where aid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setLong(1,3001);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long aid = rs.getLong("aid");
				String accountnum = rs.getString("accountnum");
				double balance = rs.getDouble("balance");
				double interestrate = rs.getDouble("interestrate");
				double overdraftamount = rs.getDouble("overdraftamount");
				String accounttype = rs.getString("accounttype");
				long customerid = rs.getLong("customerid");
				System.out.println("AID : " + aid);
				System.out.println("accountnum : " + accountnum);
				System.out.println("balance : " + balance);
				System.out.println("interestrate : " + interestrate);
				System.out.println("overdraftamount : " + overdraftamount);
				System.out.println("accounttype : " + accounttype);
				System.out.println("customerid : " + customerid);
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
