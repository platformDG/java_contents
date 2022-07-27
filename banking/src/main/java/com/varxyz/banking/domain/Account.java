package com.varxyz.banking.domain;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accType;
	protected double balance;
	private Date regDate;
	
	public Account() {
		
	}
}
