package com.varxyz.banking.domain;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	// .-대출한도액은 2만원으로 가정
	public CheckingAccount(double balance) {
		super(balance);
		overdraftAmount = 20000.0;
	}
	
	// .- 마이너스 대출한 상황에서 예금하는 상황까지 구현
	public void deposite(double amount) {
		if(balance > 0) {
			balance += amount;
		}
		else {
			// .-대출한도가 넘어서 예금을 할 수있다면 대출한도는 원상복귀
			if(20000.0 - overdraftAmount < amount ) {
				overdraftAmount = 20000.0;
			}
			else {
				overdraftAmount += amount;
			}
		}
	}
	
	public void withdraw(double amount) throws NotEnoughBalanceException {
		if (balance < amount) {
			// .-잔고 부족시 overdraftAmount 금액 한도내에서 추가 출금을 승인
			if (balance + overdraftAmount < amount) {
				throw new NotEnoughBalanceException("한도초과");
			}
			else {
				amount = amount - balance;
				overdraftAmount = overdraftAmount - amount;
			}
		}
		else {
			balance = balance - amount;
		}
		
	}
}
