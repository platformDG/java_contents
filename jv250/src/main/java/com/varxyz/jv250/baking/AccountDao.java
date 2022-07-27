package com.varxyz.jv250.baking;

import java.sql.*;
import java.util.*;

public class AccountDao {
	private static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWD = "jv250";
	
	public AccountDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ----->" + JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 신규 계좌 등록
	 * @param account		등록할 계좌정보
	 */
	public void addAccount(Account account) {
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		
		String sql = "INSERT INTO Account(accountnum, balance, interestrate, overdraftamount, accounttype, customerid) VAlUES (?, ?, ?, ?, ?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if( account instanceof SavingsAccount ) {
					sa = (SavingsAccount) account;	
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
				}
				else if( account instanceof CheckingAccount) {
					ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
				}
				pstmt.setString(5, String.valueOf(account.getAccountType()));
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			}finally {
				pstmt.close();
				con.close();
				System.out.println("INSERTED....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 등록된 모든 계좌 목록 조회
	 * @return
	 */
	public List<Account> findAllAccount(){	
		String sql = "SELECT * FROM Account";
		List<Account> accountList = new ArrayList<>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					if (rs.getString("accounttype").charAt(0) == 'S') {
						SavingsAccount sa = new SavingsAccount();
						sa.setAid(rs.getLong("aid"));
						sa.setAccountNum(rs.getString("accountnum"));
						sa.setBalance(rs.getDouble("balance"));
						sa.setInterestRate(rs.getDouble("interestrate"));
						sa.setAccountType(rs.getString("accounttype").charAt(0));
						sa.setCustomerid(rs.getLong("customerid"));
						accountList.add(sa);
					}
					else if(rs.getString("accounttype").charAt(0) == 'C') {
						CheckingAccount ca = new CheckingAccount();
						ca.setAid(rs.getLong("aid"));
						ca.setAccountNum(rs.getString("accountnum"));
						ca.setBalance(rs.getDouble("balance"));
						ca.setOverdraftAmount(rs.getDouble("overdraftamount"));
						ca.setAccountType(rs.getString("accounttype").charAt(0));
						ca.setCustomerid(rs.getLong("customerid"));
						accountList.add(ca);
					}	
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * @param ssn		주민번호
	 * @return
	 */
	public List<Account> findAccountBySsn(String ssn) throws NotEnoughBalanceException {
		String sql = "SELECT a.aid, a.accountnum, a.balance, a.interestrate, a.overdraftamount, a.accounttype,"
				+ " c.name, c.ssn, c.phone, a.regdate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerid = c.cid "
				+ " WHERE c.ssn = ?"; 
		List<Account> accountList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				while(rs.next()) {
					if (rs.getString("accounttype").charAt(0) == 'S') {
						account = new SavingsAccount();
						Customer customer = new Customer();
						customer.setName(rs.getString("name"));
						customer.setSsn(rs.getString("ssn"));
						customer.setPhone(rs.getString("phone"));
						((SavingsAccount) account).setCustomer(customer);
						
						((SavingsAccount) account).setAid(rs.getLong("aid"));
						((SavingsAccount) account).setAccountNum(rs.getString("accountnum"));
						((SavingsAccount) account).setBalance(rs.getDouble("balance"));
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestrate"));
						((SavingsAccount) account).setAccountType(rs.getString("accounttype").charAt(0));
						accountList.add(((SavingsAccount) account));
					}
					else if(rs.getString("accounttype").charAt(0) == 'C') {
						account = new CheckingAccount();
						Customer customer = new Customer();
						customer.setName(rs.getString("name"));
						customer.setSsn(rs.getString("ssn"));
						customer.setPhone(rs.getString("phone"));
						((CheckingAccount) account).setCustomer(customer);
						
						((CheckingAccount) account).setAid(rs.getLong("aid"));
						((CheckingAccount) account).setAccountNum(rs.getString("accountnum"));
						((CheckingAccount) account).setBalance(rs.getDouble("balance"));
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraftamount"));
						((CheckingAccount) account).setAccountType(rs.getString("accounttype").charAt(0));
						((CheckingAccount) account).setCustomerid(rs.getLong("customerid"));
						accountList.add(((CheckingAccount) account));
					}	
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
}
