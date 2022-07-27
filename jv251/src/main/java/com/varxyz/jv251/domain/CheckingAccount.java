package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.OverDraftException;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {
		
	}

	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public void withdraw(double amount) {
		if (balance < amount) {
			double overdraftNeaded = amount - balance;
			if(overdraftAmount < overdraftNeaded) {
				throw new OverDraftException("에러 : 대월금 초과", balance, overdraftNeaded);
			}else {
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeaded;
			}
		}
		else {
			balance = balance - amount;
		}
		
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	
//	@Override
//	public String toString() {
//		super.toString();
//		super.str += "\n 대출한도 : " + overdraftAmount
//				+ "\n==========================";
//		return super.str;
//	}
}
