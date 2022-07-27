package com.varxyz.jv300.mod010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataSource {
	//final은 선언과 동시에 선언; 최소한 생성자에서 초기값 넣기.
	private String jdbcDriver;
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	
	public DataSource(String jdbcDriver, String jdbcUrl, String jdbcUserName, String jdbcPassword) {
		this.jdbcDriver = jdbcDriver;
		this.jdbcUrl = jdbcUrl;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
		
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("ConnectionNotAvailableException");
		}
	}
	public Connection getConnection() {
		try {
		return DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
		catch(SQLException e) {
			throw new RuntimeException("ConnectionNotAvailableException");
		}
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException { 
		if(rs != null && !rs.isClosed()) {
			rs.close();	
		}
		if(pstmt != null && !pstmt.isClosed()) {
			pstmt.close();
		}
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
	
	public void close(PreparedStatement pstmt, Connection con) throws SQLException {
		close(null, pstmt, con);
	}
}
