package com.varxyz.jvx330.jdbc.example2;

import java.sql.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = 
				context.getBean("customerDao", CustomerDao.class);
//		findAllCustomers(dao);
//		findCustomerByRegDate(dao);
//		countCustomers(dao);
		findCustomerByRegDate2(dao);
	}
	
	public static void findAllCustomers(CustomerDao dao) {
		for(Customer c : dao.findAllCustomer()) {
			System.out.println(c);
		}
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		String dateStr = "2022-07-21";
		Date regDate = Date.valueOf(dateStr);
		System.out.println(dao.findCustomerByRegDate(regDate));
	}
	
	public static void countCustomers(CustomerDao dao) {
		System.out.println(dao.countCustomers());
	}
	
	public static void findCustomerByRegDate2(CustomerDao dao) {
		Date regDate = Date.valueOf("2022-07-21");
		Date regDate2 = Date.valueOf("2022-07-23");
		System.out.println(dao.findCustomerByRegDate2(regDate, regDate2));
	}
}
