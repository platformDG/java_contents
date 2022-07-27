package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;


public class AccountService {
private AccountDao accountDao;
	
	public AccountService (AccountDao accountDao) {
		this.accountDao = accountDao;
	}
//	public Account createAccount(String name, String ssn, String phone, 
//									String userId, String passwd) {
//		return new Account(name, ssn, phone, userId, passwd );
//	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public List<Account> getAccounntBySsn(String ssn) {
		return accountDao.findAccountBySsn(ssn);
	}
	public Account getAccountByAccountNum(String accountNum) {
		return accountDao.getAccountByAccountNum(accountNum);
	}
	public List<Account> getAllAccounnts(){
		return accountDao.findAllAccount();
	}
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성
	 * @return
	 */
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
	
	public void setBalanceByAccountNum(double balance, String accountNum) {
		accountDao.setBalanceByAccountNum(balance, accountNum);
	}
}
