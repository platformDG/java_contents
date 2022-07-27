package com.dgstory.a220620.test04;

import java.util.*;
/**
 * 고객의 정보를 담는 클래스
 * 고객1명당 계좌는 여러개를 소지할 수 있으므로 계좌를 동적으로 가질 수 있는 List 속성을 가진다.
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public class Customer {
	String name;
	String ssn;
	String phone;
	String customerId;
	String passwd;
	List<Account> al;
	
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
		al = new ArrayList<Account>();
	}
	
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}

	public String getPhone() {
		return phone;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getPasswd() {
		return passwd;
	}
	
	public void setAccount(Account ac) {
		al.add(ac);
	}
	
	public List<Account> getAccount(){
		return al;
	}
}
