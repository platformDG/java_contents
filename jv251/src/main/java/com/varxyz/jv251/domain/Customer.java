package com.varxyz.jv251.domain;

import java.util.*;

public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String userID;
	private String passwd;
	private List<Account> accountList;
	
	public Customer() {
		
	}
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(String name, String ssn, String phone, String userID, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userID = userID;
		this.passwd = passwd;
		accountList = new ArrayList<Account>();
	}
	
	public long getCid() {
		return cid;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<Account> getAccountList() {
		return accountList;
	}
	
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	@Override
	public String toString() {
		String str = "";
		str = "=========================="
			+ "\n 이름 : " + name
			+ "\n 주민번호 : " + ssn
			+ "\n 휴대전화 : " + phone
			+ "\n ID : " + userID
			+ "\n 비번 : " + passwd
			+ "\n==========================\n";
		return str;
	}
}
