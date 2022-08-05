package com.varxyz.banking.service;

import java.util.List;

import com.varxyz.banking.domain.Account;

public interface AccountService {
	Account addAccount(String userId, char accType, double darftOrRate, double balance);
	List<Account> getAccounts(String userId);
	String transfer(double amount, String outputAccount, String inputAccount);
	double getBalance(String accountNum);
	boolean saveInterest(double interestRate, String accountNum);
}
