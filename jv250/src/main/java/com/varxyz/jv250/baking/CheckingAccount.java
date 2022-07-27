package com.varxyz.jv250.baking;
/**
 * 마이너스 계좌 객체 추상클래스 Account를 상속받는다.
 * 
 * 작성자 : 박동근
 * 작성일 : 2022.06.20
 */
public class CheckingAccount extends Account {
	private double overdraftAmount;
	private boolean flag;
	
	public CheckingAccount() {
		
	}

	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
		flag = false;
	}
	
	/**
	 * 마이너스 대출진행 중인 상태에서 대출한도보다 예금이 커진다면 상환처리한다.
	 * 잔고부족시 NotEnoughBalanceException으로 예외발생
	 */
	public void deposite(double amount) {
		if(flag == true && balance + amount > overdraftAmount) {
			balance = balance + amount - overdraftAmount;
			flag = false;
		}else {
			balance = balance + amount;
		}
	}
	
	/**
	 * 출금메소드 잔고 부족시 대출한도내에서 추가 출금을 승인한다.
	 * 마이너스 대출 진행시 flag는 true로 변경된다.
	 * 잔고부족시 NotEnoughBalanceException으로 예외발생
	 */
	public void withdraw(double amount) throws NotEnoughBalanceException {
		if (balance < amount) {
			if (balance + overdraftAmount < amount) {
				throw new NotEnoughBalanceException("한도초과");
			}
			else {
				//잔액이 부족하니깐 한도만큼 추가해서 출금한다.
				balance = balance + overdraftAmount;
				balance = balance - amount;
				flag = true;
			}
		}
		else {
			balance = balance - amount;
		}
		
	}

	@Override
	public void setCustomer(Customer customer) {
		super.customer = customer;
	}
	
	@Override
	public Customer getCustomer() {
		return super.customer;
	}
	
	@Override
	public String getAccountNum() {
		return accountNum;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	
	@Override
	public String toString() {
		super.toString();
		super.str += "\n 대출한도 : " + overdraftAmount
				+ "\n==========================";
		return super.str;
	}
}
