package com.varxyz.banking.service;

public interface CustomerService {
	boolean addCustomer(String userId, String passwd, String name, String ssn,
			String phone);
}
