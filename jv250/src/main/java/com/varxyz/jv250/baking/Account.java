package com.varxyz.jv250.baking;

public abstract class Account {
	protected long aid;
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected char accountType;
	protected long customerid;
	protected String str = "";
	
	public Account() {
		
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		
		if(balance < 1) {
			throw new RuntimeException("마이너스 금액이 들어올 수 없습니다.");
		}
		else {
			this.balance = balance;
		}
	}
	
	public void deposite(double amount) {
		this.balance += amount;
	}
	
	public abstract void withdraw(double d) throws NotEnoughBalanceException;
	public abstract void setCustomer(Customer customer);
	public abstract Customer getCustomer();
	public abstract String getAccountNum();
	
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
	
	public long getCustomerid() {
		return customerid;
	}
	
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	
	@Override
	public String toString() {
		str = "=========================="
			+ "\n 키값 : " + aid
			+ "\n 계좌번호 : " + accountNum
			+ "\n 잔액 : " + balance
			+ "\n TYPE : " + accountType
			+ "\n 고객번호 : " + customerid;
		return str;
	}
}
