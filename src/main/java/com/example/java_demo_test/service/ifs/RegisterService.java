package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

public interface RegisterService {
	// 新增帳號
	public RegisterResponse register(String account, String pwd);
	
	// 驗證
	public RegisterResponse active(String account, String pwd);
	
	// 登入
	public RegisterResponse login(String account, String pwd);
	
	// 取得資料庫時間
	public RegisterResponse getRegTime(String account, String pwd);
	
	
	public RegisterResponse getRegTime2(RegisterRequest request,String account, String pwd, Integer verifyCode);
		
}
