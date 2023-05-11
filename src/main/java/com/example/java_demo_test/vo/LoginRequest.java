package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Login;

public class LoginRequest {
	
	private List<Login> login;
	private String account;
	private String pwd;
	


	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginRequest(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}


	public LoginRequest(List<Login> login) {
		super();
		this.login = login;
	}



	public List<Login> getLogin() {
		return login;
	}

	public void setLogin(List<Login> login) {
		this.login = login;
	}


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
	
	
	
	
	
	

}
