package com.example.java_demo_test.serviceHw.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entityHw.Menu;
import com.example.java_demo_test.respositoryHw.MenuDao;
import com.example.java_demo_test.serviceHw.ifs.GetMenuResponse;
import com.example.java_demo_test.serviceHw.ifs.OrderService;
import com.example.java_demo_test.vo.OrderResponse;

/*
 * 收到資料後的處理&新增至資料庫
 */

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MenuDao menuDao;
//    @Override

	@Override
	public OrderResponse addMenus(List<Menu> menu) {
		for (Menu menuItem : menu) {
			// 判斷menuList == null || menuList.isEmpty()
			if (CollectionUtils.isEmpty(menu)) {
				return new OrderResponse("新增餐點錯誤!");
			}

//			if(menu == null || menu.isEmpty()) {
//				return new OrderResponse("新增餐點錯誤!");
//			}

			// 檢查餐點名稱不得為空值
			if (!StringUtils.hasText(menuItem.getFood())) {
				return new OrderResponse("新增餐點不能為空值!");

			}
			if (menuItem.getPrice() <= 0) {
				return new OrderResponse("餐點價格錯誤!");
			}
		}

		List<Menu> response = menuDao.saveAll(menu);
		return new OrderResponse(response, "新增餐點成功!");
	}
	/*
	 * 用前端呼叫資料庫之資料, 存在資料庫的就顯示於postman 
	 */
	// Map<key:餐點名, value:點餐數量>
	@Override
	public OrderResponse order(Map<String, Integer> orderMap) {
		// itemList: 儲存餐點名稱(前端輸入資料)
		List<String> itemList = new ArrayList<>();
		
		for (Entry<String, Integer> item : orderMap.entrySet()) {
		// 不需要判斷空自串或是空白字串< 是因為即使帶入了空字串或空白字串, DataBase也查無資料
			if (item.getValue() < 0) {
				return new OrderResponse("餐點數量錯誤!!");
			}
			// 取得餐點名(前端)
			itemList.add(item.getKey());
		}
		// 資料庫(DataBase):取得ItemList內的所有資料存入"result"
		List<Menu> result = menuDao.findAllById(itemList);
		int totalPrice = 0;
		// 在最終正確(輸入和資料庫一致)的資料量
		Map<String, Integer> finalOrderMap = new HashMap<>();
		// 檢查
		for (Menu menu : result) {
			String item = menu.getFood(); // 餐點名稱(3比); 第一筆: beef; 第二筆: fish第3筆:pork
			
			int price = menu.getPrice();// 取得餐點價格
			for (Entry<String, Integer> map : orderMap.entrySet()) {
				String key = map.getKey(); // orderMap中的餐點名稱
				int value = map.getValue();// orderMap中的餐點數量
				
				// 前端(postman)和資料庫的資料一致時才納入
				if(item.equals(key)) {
					int singleTotalPrice = price * value; // 
					totalPrice += singleTotalPrice;
					finalOrderMap.put(key, value);
				}
			}
		}
		 //打折(滿500以上打9折)									//將double值轉成整數 
		totalPrice = totalPrice >= 500 ? (int)(totalPrice * 0.9):totalPrice;
		return new OrderResponse(finalOrderMap, totalPrice, "點餐成功!");
	}
	/*
	 *從前端發出request的對象資料和資料庫一致 
	 */
	@Override
	public GetMenuResponse getMenuByName(String name) {
		// hasText(): 是否有東西(不限於空白字串)
		if (!StringUtils.hasText(name)) {
			
			return new GetMenuResponse(); 
		}
		
		// 尋找前端資料加入菜單尋找對象, 若是有變放入backName
		Optional<Menu> backName = menuDao.findById(name);
	
		// 判斷backName有沒有值()存在
		if(!backName.isPresent()) {
			
			return new GetMenuResponse();
		}
		// Menu theName = backName.get();
		return new GetMenuResponse(backName.get(), "成功取出");
		
		
		
//		List<Menu> result = menuDao.findAllById(itemList);
//		for(Menu menu : result) {
//			String nameBank = menu.getFood();
//		}

	}

	@Override
	public OrderResponse getAllMenus() {
		return null;
	}
	/*
	 * 0418課程内容
	 */
	@Override
	public OrderResponse updateMenu(List<Menu> menuList) {
		// 可少進database再判別一次
		if(CollectionUtils.isEmpty(menuList)) {
			return new OrderResponse("菜單價格錯誤!");
			
		}
		List<String> ids = new ArrayList<>();
		
//		ids.add(menu.getItem());
		return null;
	}
//	List<Menu> res = menuDao.findAllById(ids);
//	
//	Lis
//		// TODO Auto-generated method stub
//		List<String> ids = new ArrayList<>();
//		for(Menu menu : menuList) {
//			if(menu.getPrice() < 0) {
//				
//			}
//		}
//		List<Menu>  = new ArrayList<>();
//	
//		
//		
//		
//		return new OrderResponse();
//	}

}
