package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entityHw.Menu;
import com.example.java_demo_test.serviceHw.ifs.GetMenuResponse;
import com.example.java_demo_test.serviceHw.ifs.OrderService;
import com.example.java_demo_test.vo.OrderRequest;
import com.example.java_demo_test.vo.OrderResponse;


/*
 * 和controller層進行連接(postman)
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	// PostMapping: 對照前端資料名稱是否有對上, 然後執行以下步驟
	@PostMapping(value = "add_menu")
	public OrderResponse addMenus(@RequestBody OrderRequest request) {
	
		return orderService.addMenus(request.getMenu());
	}
	
	@PostMapping(value = "getMenuByName")
	// OrderRequest:辨別出				// 負責確認外部的key值後將資料帶入OrderRequest
	public GetMenuResponse getMenuByName(@RequestBody OrderRequest request) {
	
		return orderService.getMenuByName(request.getName());
	}
	
//	@PostMapping(value = "fixThePrice")
//	// OrderRequest:辨別出
//	public GetMenuResponse updateMenu(@RequestBody OrderRequest request) {
//	
//		return orderService.updateMenu(request.getName());
//	}
}
