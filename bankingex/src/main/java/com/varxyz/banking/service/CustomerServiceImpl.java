package com.varxyz.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	@Override
	public boolean addCustomer(String userId, String passwd, String name, String ssn,
			String phone) {
		Customer c = new Customer();
		c.setUserId(userId);
		c.setPasswd(passwd);
		c.setName(name);
		c.setSsn(ssn);
		c.setPhone(phone);
		
		return dao.addCustomer(c);	
	}
	public Customer findCustomerByUserId(String userId) {
		return dao.findCustomerByUserId(userId);
	}
	public int findCustomerByUserIdPasswd(String userId, String passwd) {
		return dao.findCustomerByUserIdPasswd(userId, passwd);
	}
}
