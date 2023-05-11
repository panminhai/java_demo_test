package com.example.java_demo_test.serviceHw.ifs;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entityHw.Menu;
import com.example.java_demo_test.vo.OrderResponse;

public interface OrderService {
	/*
	 * ì‹Æ:›‰ìgetmenuby name
	 */
	//  getMenuResponse(Map<food_name, price>, Message), name: `êy–¼âi
	public GetMenuResponse getMenuByName(String name);
	
	public OrderResponse getAllMenus();
	
	// Response‘è–Ú
	public OrderResponse addMenus(List<Menu> menuList) ;

	public OrderResponse order(Map<String, Integer> orderMap) ;
	/*(Response)
	 * 1. ‘ü”\C‰ü›ß‘¶İ“IØšd™JŠi(•s“¾ˆ×•‰É)/•s‘¶İ“I™JŠi•s“¾Vú
	 * 2. 
	 */
	public OrderResponse updateMenu(List<Menu> menuList);


}
