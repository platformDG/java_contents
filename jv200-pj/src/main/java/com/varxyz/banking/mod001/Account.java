package com.varxyz.banking.mod001;

public class Account {
	private double balance;
	public Account(double initBalance) {
		this.balance = initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	public void widthdraw(double amt) {
		if( balance - amt < 0 ) {
			System.out.println("잔액이 부족합니다.");
		}
		else {
			this.balance -= amt;	
		}
		
	}
}
