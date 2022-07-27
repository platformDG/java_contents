package com.varxyz.jv251.domain;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount() {
	}
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) {
		super.balance -= amount;
	}
	
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Customer getCustomer() {
		return this.customer;
	}
	
	@Override
	public String getAccountNum() {
		return accountNum;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
//	@Override
//	public String toString() {
//		super.toString();
//		super.str += "\n 이자율 : " + interestRate
//				+ "\n==========================";
//		return super.str;
//	}
	
}
