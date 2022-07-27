package com.varxyz.jv250.baking;

import java.util.*;
/**
 * 고객의 정보를 담는 클래스
 * 고객1명당 계좌는 여러개를 소지할 수 있으므로 계좌를 동적으로 가질 수 있는 List 속성을 가진다.
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
/**
 * @author Administrator
 *
 */
public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String customerId;
	private String passwd;
	private List<Account> al;
	public Customer() {
		
	}
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
		al = new ArrayList<Account>();
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public List<Account> getAccount() {
		return al;
	}
	public void setAccount(Account ac) {
		al.add(ac);
	}

	public String toString() {
		String str = "";
		str = "=========================="
			+ "\n 이름 : " + name
			+ "\n 주민번호 : " + ssn
			+ "\n 휴대전화 : " + phone
			+ "\n ID : " + customerId
			+ "\n 비번 : " + passwd
			+ "\n==========================\n";
		return str;
	}
}
