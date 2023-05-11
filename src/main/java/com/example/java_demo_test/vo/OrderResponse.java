package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entityHw.Menu;
/*
 * ›’ˆÈŽæ“¾
 */
public class OrderResponse {

	private int originalTotalPrice;

	private int totalPrice;

	private List<Menu> menuList;

	public int getOriginalTotalPrice() {
		return originalTotalPrice;
	}

	private Map<String, Integer> orderMap;

	private String message;

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponse(List<Menu> menuList, String message) {
		super();
		this.menuList = menuList;
		this.message = message;
	}

	public Map<String, Integer> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Integer> orderMap) {
		this.orderMap = orderMap;
	}

	public void setOriginalTotalPrice(int originalTotalPrice) {
		this.originalTotalPrice = originalTotalPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderResponse(String message) {
		super();
		this.message = message;
	}

	public OrderResponse(Map<String, Integer> orderMap, int totalPrice, String message) {

		this.orderMap = orderMap;
		this.totalPrice = totalPrice;
		this.message = message;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
