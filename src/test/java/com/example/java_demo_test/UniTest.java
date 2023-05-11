package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entityHw.Menu;
import com.example.java_demo_test.respositoryHw.MenuDao;
import com.example.java_demo_test.serviceHw.ifs.OrderService;
import com.example.java_demo_test.vo.OrderResponse;

@SpringBootTest(classes = JavaDemoTestApplication.class)
/*
 * “U“ü‘—¿(`êy&™JŠi)
 */
public class UniTest {
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private OrderService orderService;
//	public static void main(String[] args){
	
	@Test
	public void sendMenu() {
		
		 List<Menu> list = new ArrayList<>(Arrays.asList(new Menu("beef", 120), new Menu("fish", 100)));
//	     List<Menu> responseList = Response.getMenuits();
		 OrderResponse response = orderService.addMenus(list);
		 List<Menu> responseList = response.getMenuList();
		 Assert.isTrue(responseList != null,"Vú`êyöŒë!");
	}
//	private OrderService

	
	
	
	}	

