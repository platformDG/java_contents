package com.dgstory.a220620.test04;

import java.util.*;
/**
 * 고객의 정보를 컨트롤 할 수 있는 인터페이스 클래스
 * 추상메소드 4가지를 가진다.
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public interface CustomerService {
	void addCustomer(Customer c);
	Customer getCustomerBySsn(String ssn);
	Collection<Customer> getAllCustomer();
	public int getNumOfCustomers();
}
