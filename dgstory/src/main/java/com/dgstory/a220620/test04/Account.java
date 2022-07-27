package com.dgstory.a220620.test04;
/**
 * 계좌의 정보를 가지는 추상 클래스
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public abstract class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	
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
}
