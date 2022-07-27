package com.varxyz.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);	
	}
	public Customer findCustomerByUserId(String userId) {
		return dao.findCustomerByUserId(userId);
	}
	public int findCustomerByUserIdPasswd(String userId, String passwd) {
		return dao.findCustomerByUserIdPasswd(userId, passwd);
	}
}
