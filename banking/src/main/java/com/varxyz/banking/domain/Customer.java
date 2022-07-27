package com.varxyz.banking.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
	
	public Customer() {
		
	}
}
