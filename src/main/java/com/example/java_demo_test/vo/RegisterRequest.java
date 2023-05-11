package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRequest {
	
	private String account;
	
	private String pwd;

	@JsonProperty("verify_code")
	private int verifyCode;
	
	
	public String getAccount() {
		return account;
	}
	

	public RegisterRequest() {
		super();
	}
	
	

	public RegisterRequest(String account, String pwd, int verifyCode) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.verifyCode = verifyCode;
	}


	public RegisterRequest(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
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


	public int getVerifyCode() {
		return verifyCode;
	}


	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	
	
	
	
	

}
