package com.varxyz.jv251.dao;

import java.util.*;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.exception.InsufficientBalanceException;

public class DaoTest {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();

		List<Account> accountList;
		try {
			accountList = dao.findAccountBySsn("901213-1167521");
			for(Account account : accountList) {
				System.out.println(account.toString());
			}
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
		
	}
}
