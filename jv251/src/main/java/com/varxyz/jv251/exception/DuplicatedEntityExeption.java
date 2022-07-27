package com.varxyz.jv251.exception;

@SuppressWarnings("serial")
public class DuplicatedEntityExeption extends RuntimeException {
	public DuplicatedEntityExeption(String msg) {
		super(msg);
	}
}
