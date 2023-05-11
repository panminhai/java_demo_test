package com.example.java_demo_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name = "account")
	private String account;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "city")
	private String city;
	
	// Date ==> new Date()
	@Column(name = "register")
	private LocalDateTime regTime;
	
	@Column(name = "active")
	private boolean isActive;

	
	public Login() {
		super();
	}

	
	

	public Login(boolean isActive) {
		super();
		this.isActive = isActive;
	}


	public Login(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}


	public Login(String account, String pwd, String name, int age, String city, LocalDateTime regTime,
			boolean isActive) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.city = city;
		this.regTime = regTime;
		this.isActive = isActive;
	}



	public Login(String account, String pwd, String name, int age, String city) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.city = city;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// isActive: Activeà◊ê^(True)
	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	
	
	
	
	
}
