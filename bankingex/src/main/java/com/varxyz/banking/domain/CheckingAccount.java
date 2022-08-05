package com.varxyz.banking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public void deposite(double amount) { 
		balance += amount;
	}

	//출금
	public boolean withdraw(double amount) {
		if (balance - amount < 0) {
			if(balance + overdraftAmount - amount < 0) {
				System.out.println("잔고부족");
				return false;
			}
			else {
				balance -= amount;
				return true;
			}
		}
		balance -= amount;
		return true;
	}
}
