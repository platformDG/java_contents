package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.Customer;


public class AccountDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(example5Config.class);
		AccountDao dao = 
				context.getBean("accountDao", AccountDao.class);
		
		addAccount(dao);
		//findAllAccount(dao);
		//findAccountBySsn(dao);
		//findAccountByCustomerId(dao);
		context.close();
	}
	
	public static void addAccount(AccountDao dao) {
		SavingsAccount a = new SavingsAccount();
		
		a.setAccountNum("222-22-2222");
		a.setAccType('S');
		a.setBalance(5000.0);
		a.setInterestRate(2.5);
		a.setCustomer(new Customer(1001));
		
		dao.addAccount(a);
	}
	
	public static void findAllAccount(AccountDao dao) {
		for(Account a : dao.findAllAccount()) {
			System.out.println(a);
		}
	}
	
	public static void findAccountBySsn(AccountDao dao) {
		System.out.println(dao.findAccountBySsn("880211-1111111"));
	}
	
	public static void findAccountByCustomerId(AccountDao dao) {
		System.out.println(dao.findAccountByCustomerId(1001));
	}
}
