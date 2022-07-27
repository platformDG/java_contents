package com.varxyz.jv250.baking;
/**
 * 일반계좌 객체 추상클래스 Account를 상속받는다.
 * 
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */

public class SavingsAccount extends Account {
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;
	
	public SavingsAccount() {
	}
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTEREST_RATE);
	}
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) throws NotEnoughBalanceException {
		if (balance - amount < 0) {
			throw new NotEnoughBalanceException("잔고부족");
		}
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
	@Override
	public String toString() {
		super.toString();
		super.str += "\n 이자율 : " + interestRate
				+ "\n==========================";
		return super.str;
	}
	
}
