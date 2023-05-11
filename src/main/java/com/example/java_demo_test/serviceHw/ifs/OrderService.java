package com.example.java_demo_test.serviceHw.ifs;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entityHw.Menu;
import com.example.java_demo_test.vo.OrderResponse;

public interface OrderService {
	/*
	 * ���:����getmenuby name
	 */
	//  getMenuResponse(Map<food_name, price>, Message), name: �`�y���i
	public GetMenuResponse getMenuByName(String name);
	
	public OrderResponse getAllMenus();
	
	// Response���
	public OrderResponse addMenus(List<Menu> menuList) ;

	public OrderResponse order(Map<String, Integer> orderMap) ;
	/*(Response)
	 * 1. ���\�C���ߑ��ݓI�ؚd�J�i(�s���ו���)/�s���ݓI�J�i�s���V��
	 * 2. 
	 */
	public OrderResponse updateMenu(List<Menu> menuList);


}
