package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Bank;

// ‰ñœä™|—
public class BankResponse {
	public Bank getBank() {
		return bank;
	}

	public BankResponse(Bank bank, String message) {
		super();
		this.bank = bank;
		this.message = message;
	}

	public BankResponse() {
		super();
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Bank bank;
	
	private String message;
}
