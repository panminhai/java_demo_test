package com.example.java_demo_test.serviceHw.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.respository.LoginDao;
import com.example.java_demo_test.serviceHw.ifs.LoginService;
import com.example.java_demo_test.vo.LoginResponse;

@Service
public class LoginServiceImpl implements LoginService {
	
	// 帳號長度設定
	private String pattern = "\\w{3,8}";
	
	// 密碼格式設定
	private String patternPwd = "\\W{1}\\w{7,11}";
	
	private String patternPwd2 = "^(?=)$";

	@Autowired
	private LoginDao loginDao;
	// 先處理空直null值再執行
	@Override
	public LoginResponse addLoginData(List<Login> login) {
	// for() // 前端是否有在資料庫條件式
		if(CollectionUtils.isEmpty(login)) {
			return new LoginResponse("帳號和密碼請確實填入!");
		}
		
		//資料逐一檢查: 帳號
		List<String> Account = new ArrayList<>();
		for(Login item : login) {
			
			// 防呆: 檢查帳號格式(Null, 空白)
			if(!StringUtils.hasText(item.getAccount())) {
				return new LoginResponse("帳號輸入失敗!請檢查是否輸入!");
			}
			
			// 防呆: 檢查帳號格式(3~8)
			if(!item.getAccount().matches(pattern)) {
				return new LoginResponse("帳號輸入失敗!請檢查正確格式!");
			}
			
//			Account.add(item.getAccount());
		}
		
		
		// 資料逐一檢查: 密碼
		List<String> pwd = new ArrayList<>();
		for(Login item : login) {
			
			if(!StringUtils.hasText(item.getPwd())){
				return new LoginResponse("密碼輸入失敗!請檢查是否輸入!");
			}
			
			if(!item.getPwd().matches(patternPwd)) {
				return new LoginResponse("密碼輸入失敗!請檢查正確格式!");
			}
			
//			Account.add(item.getPwd());

		}
		
		loginDao.saveAll(login);
		return new LoginResponse("輸入資訊皆正常!");
	}
	
	@Override
	public LoginResponse verifyTheData(String Account, String Pwd) {
		// 帳號是否存在於資料庫? Y:active=1, N:active=0
		List<Login> sqlLogin = loginDao.findAll();
		
		if(!StringUtils.hasText(Account) || !StringUtils.hasText(Pwd)) {
			
			return new LoginResponse("帳號密碼輸入錯誤!");
		}
		
			for(Login item : sqlLogin) {
					
				// 數據庫資料取得(帳號, 密碼)
				if(Account.equals(item.getAccount()) && 
						Pwd.equals(item.getPwd())){
				
				if(item.isActive() == false) {
					
					item.setActive(true);
					
					
					loginDao.save(item);
					
					return new LoginResponse("驗證成功!");
	
					}
				
					return new LoginResponse("此帳號已被驗證!");
				}
			
				return new LoginResponse("此帳號不存在!");
			}
		
//		if(login.equals(sqlLogin)) {
//			
//			for()
//			loginDao.findAllById()
			
			
//		}
		
		
		return null;
	}

}
