package com.dgstory.a220622.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountJDBCTest {
	public static void main(String[] args) {
		String driver ="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ----->" + driver);
			
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED DRIVER ----->" + url);
			select(con);
			insert(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long aid = rs.getLong("aid");
				String accountnum = rs.getString("accountnum");
				double balance = rs.getDouble("balance");
				double interestrate = rs.getDouble("interestrate");
				double overdraftamount = rs.getDouble("overdraftamount");
				char accounttype = rs.getString("accounttype").charAt(0);
				long customerid = rs.getLong("customerid");
				System.out.println("AID : " + aid);
				System.out.println("accountnum : " + accountnum);
				System.out.println("balance : " + balance);
				System.out.println("interestrate : " + interestrate);
				System.out.println("overdraftamount : " + overdraftamount);
				System.out.println("accounttype : " + accounttype);
				System.out.println("customerid : " + customerid);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountnum, customerid) VAlUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"222-22-2222");
			pstmt.setLong(2,1001);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Connection con) {
		String sql = "UPDATE Account SET balance =?, interestrate=? WHERE aid=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1,5000.0);
			pstmt.setDouble(2,2.5);
			pstmt.setLong(3,3002);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
