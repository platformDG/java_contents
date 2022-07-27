package com.varxyz.banking.domain;

public class MainTest {
	public static void main(String[] args) {
		// .-초기 계좌 생성
		Account ac1 = new SavingsAccount(10000.0);
		Account ac2 = new CheckingAccount(500.0);
		
		// .-예금 진행
		ac1.deposite(5000.0);
		ac2.deposite(5000.0);
		
		// .-일반계좌 출금로직 잔고부족시 NotEnoughBalanceException 예외처리 발생
		try {
			ac1.withdraw(5000.0);
		}catch(NotEnoughBalanceException e) {
			e.getMessage();
		}
		
		// .-마이너스계좌 출금로직 잔고부족시 NotEnoughBalanceException 예외처리 발생		
		try {
			ac2.withdraw(5000.0);
		}catch(NotEnoughBalanceException e) {
			e.getMessage();
		}
	}
}
