package com.varxyz.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingsAccount;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao dao;
	
	@Autowired
	private CustomerDao cDao;
	
	public void addAccount(String userId, char accType, double darftOrRate, double balance) {
		Account a = null;

		if (accType == 'S') {
			a = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) a;
			sa.setInterestRate(darftOrRate);
		}
		else {
			a = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) a;
			ca.setOverdraftAmount(darftOrRate);
		}
		a.setBalance(balance);
		a.setCustomer(cDao.findCustomerByUserId(userId));
		a.setAccountNum(generateAccountNum());
		a.setAccType(accType);
		dao.addAccount(a);	
	}
	public List<Account>  findAllAccount() {
		return dao.findAllAccount();
	}
	public List<Account> findAccountByCustomerId(String userId) {
		return dao.findAccountByCustomerId(cDao.findCustomerByUserId(userId).getCid());
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		return dao.findAccountByAccountNum(accountNum);
	}
	
	public void setBalance(String accountNum, double balance) {
		dao.setBalance(accountNum, balance);
	}

	public String generateAccountNum() {
		String numStr = String.valueOf((int)(Math.random()*1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0,3));
		sb.append('-');
		sb.append(numStr.substring(3,5));
		sb.append('-');
		sb.append(numStr.substring(5,9));
		return sb.toString();
	}
}
