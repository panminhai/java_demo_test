package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

public class GetPersonInfoResponse {
	// 回傳內容(personInfo, message)
	private PersonInfo personInfo;
	private String message;
	private List<PersonInfo> allData;

	public GetPersonInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPersonInfoResponse(String message) {
		super();
		this.message = message;
	}

	public GetPersonInfoResponse(PersonInfo personInfo, String message) {
		super();
		this.personInfo = personInfo;
		this.message = message;
	}

	public GetPersonInfoResponse(List<PersonInfo> allData, String message) {
		super();
		this.message = message;
		this.allData = allData;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PersonInfo> getAllData() {
		return allData;
	}

	public void setAllData(List<PersonInfo> allData) {
		this.allData = allData;
	}

}
