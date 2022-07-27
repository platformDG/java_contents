package com.varxyz.jv250.baking;

import java.util.*;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		//findAllCustomer() Test
		List<Customer> customerList = dao.findAllCustomers();
		for(Customer csutomer : customerList) {
			System.out.println(csutomer.toString());
		}
	}
}
