package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
/*
 * “o‹Lrequest’[á¢o“I—v‹(—Ş—`œK’ù`šd)
 */
public class AddPersonInfoRequest {
	private List<PersonInfo> resPersonInfo;
	private int age;


	
	public AddPersonInfoRequest() {
		super();
	}

	public AddPersonInfoRequest(List<PersonInfo> resPersonInfo) {
		super();
		this.resPersonInfo = resPersonInfo;
	}

	public List<PersonInfo> getResPersonInfo() {
		return resPersonInfo;
	}

	public void setResPersonInfo(List<PersonInfo> resPersonInfo) {
		this.resPersonInfo = resPersonInfo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	

}
