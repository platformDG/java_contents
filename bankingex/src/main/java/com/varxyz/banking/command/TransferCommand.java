package com.varxyz.banking.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferCommand {
	private double balance;
	private String outputAccountNum;
	private String inputAccountNum;
	private String passwd;
	private String userId;
}
