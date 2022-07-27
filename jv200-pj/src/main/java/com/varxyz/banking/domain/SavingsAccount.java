package com.varxyz.banking.domain;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(double balance) {
		super(balance);
	}
	
	public void withdraw(double amount) throws NotEnoughBalanceException {
		if (balance - amount < 0) {
			throw new NotEnoughBalanceException("잔고부족");
		}
		super.balance -= amount;
	}
}
