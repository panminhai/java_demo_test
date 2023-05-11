package com.example.java_demo_test.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.respository.RegisterDao;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;


@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;
	
	
	// method1: 註冊帳號
	@Override
	public RegisterResponse register(String account, String pwd) {

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {

			return new RegisterResponse("cannot empty!");
		}

		Register reg = new Register(account, pwd);

		try {
			// 儲存置資料庫, active狀態 = "false"
			registerDao.save(reg);
		}
		catch(Exception e){
			
			return new RegisterResponse("The data is wrong!");

		}
		
		
		return new RegisterResponse("Successful!");
	}

	// method2: 驗證帳號
	@Override
	public RegisterResponse active(String account, String pwd) {

		List<Register> sqlRegister = registerDao.findAll();		
		Register resLogInfo = registerDao.findByAccountAndPwd(account, pwd);

		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {

			return new RegisterResponse("cannot empty!");
		}

		// 取得資料庫帳號密碼
//		for(Register item : sqlRegister) {
			
			// 驗證帳號條件
//			if(account.equals(item.getAccount()) && pwd.equals(item.getPwd())
//					&& item.isActive() == false) {
			
		/*
		 *  用findBy的方式找到帳號的情況(物件類型可直接等於null, 不需要.equals)
		 */
		if(!(resLogInfo == null)) {
			
			resLogInfo.setActive(true);

			registerDao.save(resLogInfo);
		
			return new RegisterResponse("Verify Successful!");

		}
		
		else {

			return new RegisterResponse("This user data isn't exist!");
			
		}
			
		
		
	}

	// method3: 登入帳號
	@Override
	public RegisterResponse login(String account, String pwd) {
		
//		List<Register> sqlRegister = registerDao.findAll();

		Register resLogInfo = registerDao.findByAccountAndPwd(account, pwd);
//		Register b = registerDao.findByAccountAndActive(account, pwd, false);
		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {

			return new RegisterResponse("cannot empty!");

		}
		
		else if (resLogInfo == null) {

			return new RegisterResponse("can't find the data!");
		}
		
		else if(resLogInfo.isActive() == false) {
			return new RegisterResponse("data didn't get verify!");
	
		}
		
		else {
			return new RegisterResponse("Login Successful!");

		}
		// 非使用Dao(Jpa)文法
//		for(Register item : sqlRegister){
//			
//			if(account.equals(item.getAccount()) && pwd.equals(item.getPwd()) && 
//					item.isActive() == true){
//				
//				return new RegisterResponse("Login Successful!");
//
//			}
//		}

		
	}

	// method4: 取得註冊時間
	@Override
	public RegisterResponse getRegTime(String account, String pwd) {
		
		Register resLogInfo = registerDao.findByAccountAndPwd(account, pwd);

		LocalDateTime resTime = resLogInfo.getRegTime();
		
//		if(!resLogInfo.equals(null) && resLogInfo.isActive() == true) {
		if(!(resLogInfo == null) && resLogInfo.isActive() == true) {

			return new RegisterResponse("get the time Successful!", resTime);

		}
		
		else {
			return new RegisterResponse("cann't find the data!");

		}
		
	}

	@Override
	public RegisterResponse getRegTime2(RegisterRequest request, String account, String pwd, Integer verifyCode) {

		
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("Please login!!");
		}
		
		if(verifyCode == null || verifyCode != request.getVerifyCode()) {
			
			return new RegisterResponse("Verify code incorrect!!");

			
		}
		
		Register reg = registerDao.findByAccountAndPwdAndActive(account, pwd, true);
		
		if(reg == null) {
			return new RegisterResponse("Please login!!");
		}
		
		return new RegisterResponse("Successful!!", reg.getRegTime());
	}

}
