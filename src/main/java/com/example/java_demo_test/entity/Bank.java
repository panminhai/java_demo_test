package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*mySQLとの連携設置*/
@Entity
@Table(name = "bank") // データベース”bank”にアクセス


public class Bank {
	/*
	 * (MySQL資料欄位)
	 */
	@Id // 本コラムをPrimeKeyに指定
	@Column(name = "account")
	private String account;
	
	@Column(name = "amount")
	private int amount;
	

	//	private int balance;
	@Column(name = "pwd")
	private String pwd;
	
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	public Bank(String account, String pwd, int amount) {
		this.account = account;
		this.amount = amount;
		this.pwd = pwd;
	}
//	public int getBalance() {
//		return balance;
//	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
//	public Bank(String account, int amount, String pwd) {
//		
//		this.account = account;
//		this.amount = amount;
//		this.pwd = pwd;
//	}
	
	
}
