package com.dgstory.a220620.test04;

import java.util.*;
/**
 * 계좌정보를 컨트롤 할 수 있는 클래스, AccountService 인터페이스를 상속받는다.
 * 
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public class AccountServiceImpl implements AccountService{
	private static AccountService service  = new AccountServiceImpl();
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerservice;
	
	private AccountServiceImpl() {
		customerservice = CustomerServiceImpl.getInstance();
	}
	public static AccountService getInstance() {
		return service;
	}
	
	public Account createSavingAccount(String accountNum, double balance) {
		return new SavingsAccount(accountNum, balance);
	}
	
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount) {
		return new CheckingAccount(accountNum, balance, overdraftAmount);
	}
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	public void addAccount(Account account, String ssn) {
		Customer customer = customerservice.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	public List<Account> getAccountBySsn(String ssn){
		Customer customer = customerservice.getCustomerBySsn(ssn);
		List<Account> alist = new ArrayList<Account>();
		for(Account ac : accountList) {
			if(ac.getCustomer().getSsn() == customer.getSsn() ) {
				alist.add(ac);
			}
		}
		return alist;
	}
	
	public Account getAccountByAccountNum(String accountNum){
		for(Account ac : accountList) {
			if (ac.getAccountNum().equals(accountNum) ) {
				return ac;
			}
		}
		return null;
	}
}
