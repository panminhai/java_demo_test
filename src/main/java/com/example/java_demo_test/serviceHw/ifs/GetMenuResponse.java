package com.example.java_demo_test.serviceHw.ifs;

import java.util.Map;

import com.example.java_demo_test.entityHw.Menu;

public class GetMenuResponse {
	
	private Menu menu;
	

	private String message;


	public GetMenuResponse() {
		super();
	}


	public GetMenuResponse(Menu menu, String message) {
		super();
		this.menu = menu;
		this.message = message;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	


	

	
}
