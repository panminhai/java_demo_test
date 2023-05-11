package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

/*
 * 外端訊息回應
 */
public class PersonInfoResponse {
	
	// 回傳內容(resPersonInfo, message)
	// resPersonInfo: 回復訊息&結果(前端要輸入)
	private List<PersonInfo> resPersonInfo;
	
	private String message;

	

	public PersonInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonInfoResponse(List<PersonInfo> resPersonInfo, String message) {
		super();
		this.resPersonInfo = resPersonInfo;
		this.message = message;
	}
	
	public PersonInfoResponse(String message) {
		super();
		this.message = message;
	}

	public List<PersonInfo> getResPersonInfo() {
		return resPersonInfo;
	}

	public void setResPersonInfo(List<PersonInfo> resPersonInfo) {
		this.resPersonInfo = resPersonInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
