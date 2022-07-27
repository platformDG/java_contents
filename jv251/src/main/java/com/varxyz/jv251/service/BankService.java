package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.DuplicatedEntityExeption;

public class BankService {
	private static final BankService service = new BankService();
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INTEREST_RATE = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT = 1000.0;
	
	public CustomerService customerService;
	public AccountService accountService;
	
	private BankService() {
		init();
	}
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}
	
	public static BankService getInstance() {
		return service;
	}
	
	public void addCustomer(String name, String ssn, String phone, 
			String userId, String passwd) {
		if(!isCustomer(ssn)) {
			customerService.addCustomer(customerService
					.createCustomer(name, ssn, phone, userId, passwd));
		}else {
			throw new DuplicatedEntityExeption(ssn + " is duplicated.");
		}
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	public void addSavingAccount(double balance, double interestRate, String ssn)
											  throws CustomerNotFoundException {
		SavingsAccount account = new SavingsAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setAccountType(BankService.SA);
		account.setInterestRate(interestRate);
		account.setBalance(balance);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not Found.");
		}	
	}
	
	public void addCheckingAccount(double balance, double overDraftAmount, String ssn) 
										throws CustomerNotFoundException {
		CheckingAccount account =  new CheckingAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overDraftAmount);
		account.setBalance(balance);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not Found.");
		}
	}
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	public List<Account> getAccounntBySsn(String ssn) {
		return accountService.getAccounntBySsn(ssn);
	}
	
	
	public void setDeposite(double balance, String accountNum) {
		/**
		 * 1.계좌번호로 계좌번호 객체 가져온다.
		 * 2. 가져온 객체에 입금메소드를 사용한다.
		 * 3. 입금메소드를 통해서 입금된 잔액을 서비스함수에 넣는다. 
		 */
		Account account = accountService.getAccountByAccountNum(accountNum);
		if (account instanceof SavingsAccount) {
			((SavingsAccount) account).deposite(balance);
			accountService.setBalanceByAccountNum(((SavingsAccount) account).getBalance(), accountNum);
		}
		else if (account instanceof CheckingAccount) {
			((CheckingAccount) account).deposite(balance);
			accountService.setBalanceByAccountNum(((CheckingAccount) account).getBalance(), accountNum);
		}
		
	}
	
	public void setWithdraw(double balance, String accountNum) {
		/**
		 * 1.계좌번호로 계좌번호 객체 가져온다.
		 * 2. 가져온 객체에 출금메소드를 사용한다.
		 * 3. 출금메소드를 통해서 입금된 잔액을 서비스함수에 넣는다. 
		 */
		Account account = accountService.getAccountByAccountNum(accountNum);
		if (account instanceof SavingsAccount) {
			((SavingsAccount) account).withdraw(balance);
			accountService.setBalanceByAccountNum(((SavingsAccount) account).getBalance(), accountNum);
		}
		else if (account instanceof CheckingAccount) {
			((CheckingAccount) account).withdraw(balance);
			accountService.setBalanceByAccountNum(((CheckingAccount) account).getBalance(), accountNum);
		}
	}
}
