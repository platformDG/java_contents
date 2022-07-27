package com.varxyz.jv250.baking;

public class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException(String msg) {
		super(msg);
	}
}
