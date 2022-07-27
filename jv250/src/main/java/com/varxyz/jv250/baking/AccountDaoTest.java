package com.varxyz.jv250.baking;

import java.util.*;

public class AccountDaoTest {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
//		Account account = new SavingsAccount("444-44-4444", 6000.0);
//		account.setAccountType('S');
//		dao.addAccount(account);
		
		//findAllAccount() Test
//		List<Account> accountList = dao.findAllAccount();
//		for(Account account : accountList) {
//			System.out.println(account.toString());
//		}
		
//		findAccountBySsn() Test
		List<Account> accountList;
		try {
			accountList = dao.findAccountBySsn("901213-1167521");
			for(Account account : accountList) {
				System.out.println(account.toString());
			}
		} catch (NotEnoughBalanceException e) {
			e.printStackTrace();
		}
		
	}
}
