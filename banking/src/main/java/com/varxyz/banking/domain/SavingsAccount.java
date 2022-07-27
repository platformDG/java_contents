package com.varxyz.banking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	private double interestRate;
	
	public void deposite(double amount) {
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		if (balance - amount < 0) {
			System.out.println("잔고부족");
			return false;
		}
		balance -= amount;
		return true;
	}
	
	public boolean saveInterrest() {
		if(balance == 0) {
			return false;
		}
		balance += Math.ceil( (balance * interestRate) / 12 );
		return true;
	}
}
