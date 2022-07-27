package com.varxyz.jv251.domain;

import java.util.*;

import com.varxyz.jv251.exception.InsufficientBalanceException;

public abstract class Account {
	protected long aid;
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected Date regDate;
	protected char accountType;
	
	public Account() {
		
	};
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	};
	
	public void deposite(double amount) {
		this.balance += amount;
	};
	
	public void withdraw(double d) throws InsufficientBalanceException{
		
	};
	public void setCustomer(Customer customer) {
		this.customer = customer;
	};
	public Customer getCustomer() {
		return customer;
	};
	
	public String getAccountNum() {
		return accountNum;
	};
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public long getAid() {
		return aid;
	}
	
	public void setAid(long aid) {
		this.aid = aid;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public char getAccountType() {
		return accountType;
	}
	
	public void setAccountType(char accounttype) {
		this.accountType = accounttype;
	}

	@Override
	public String toString() {
		return  "=========================="
			+ "\n 키값 : " + aid
			+ "\n 계좌번호 : " + accountNum
			+ "\n 잔액 : " + balance
			+ "\n TYPE : " + accountType
			+ "\n==========================";
	}
}
