package com.example.java_demo_test.constants;

// 常數定義
public enum RtnCode {
	
	// 狀態: 成功為200, 以外的數字皆為錯誤
	SUCCESSFUL("200", "Successful!!!"), 
	CANNOT_EMPTY("400", "Account or password is empty!!"),
	DATALIST_ERROR("400", "Can't find the Data!!"),
	DATA_ERROR("400", "Account or password is error!!"),
	NOT_FOUND("404", "Not found!!");
	
	
	
	private String code;
	
	private String message;
	
	

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
