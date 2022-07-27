package com.dgstory.a220620.test04;

import java.util.*;
/**
 * 고객의 정보를 컨트롤 할 수 있는 클래스, 인터페이스 CustomerService 상속을 받는다.
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public class CustomerServiceImpl implements CustomerService {
	private static CustomerService service = new CustomerServiceImpl();
	private List<Customer> aList = new ArrayList<Customer>();
	
	private CustomerServiceImpl() {
		super(); //안써주면 자동생성.
	}
	
	public static CustomerService getInstance() {
		return service;
	}
	
	public void addCustomer(Customer c) {
		if(getCustomerBySsn(c.getSsn()) == null) {
			aList.add(c);
		}
	}

	public Customer getCustomerBySsn(String ssn) {
		for(Customer cc : aList) {
			if(cc.getSsn() == ssn) {
				return cc;
			}
		}
		return null;
	}

	public Collection<Customer> getAllCustomer() {
		return aList;
	}

	public int getNumOfCustomers() {
		return aList.size();
	}
}
