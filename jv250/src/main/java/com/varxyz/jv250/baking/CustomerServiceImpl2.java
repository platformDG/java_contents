package com.varxyz.jv250.baking;

import java.util.*;

public class CustomerServiceImpl2 implements CustomerService {
	Map<String, Customer> map = new HashMap<String, Customer>();
	
	public void addCustomer(Customer c) {
		if(!map.containsKey(c.getSsn())) {
			map.put(c.getSsn(), c);
		}
	}

	public Customer getCustomerBySsn(String ssn) {
		if(map.containsKey(ssn)) {
			return map.get(ssn);
		}
		return null;
	}

	public Collection<Customer> getAllCustomer() {
		return map.values();
	}

	public int getNumOfCustomers() {
		return map.size();
	}
}
