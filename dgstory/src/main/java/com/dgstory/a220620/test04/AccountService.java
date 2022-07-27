package com.dgstory.a220620.test04;

import java.util.List;
/**
 * 계좌정보를 컨트롤 할 수 있는 인터페이스
 * 
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public interface AccountService {
	public Account createSavingAccount(String accountNum, double balance);
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);
	public void addAccount(Account account);
	public void addAccount(Account account, String ssn);
	public List<Account> getAccountBySsn(String ssn);
	public Account getAccountByAccountNum(String accountNum);
}