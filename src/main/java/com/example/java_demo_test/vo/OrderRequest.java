package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entityHw.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

// OrderRequest: 負責辨識資料
public class OrderRequest {
	// 取得前端(Postman)的資料並放入List裡
	@JsonProperty("menu_list")
	List<Menu> menu;
	
	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}
