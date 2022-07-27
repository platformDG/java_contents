package com.varxyz.banking.domain;

public class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException(String msg) {
		super(msg);
	}
}
