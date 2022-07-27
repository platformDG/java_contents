package com.varxyz.banking.domain;
/**
 * Q.1 A 팀과 B 아닌팀과 농구대결에서 A팀이 198 : 98 로 대승리하였습니다.
 *     두 팀간의 점수차는 얼마인가요 ? 
 * 
 * @작성자: 박동근
 *
 */
public abstract class Account {
	protected String accountNum;
	protected double balance;
	
	public Account(double balance) {
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
}
