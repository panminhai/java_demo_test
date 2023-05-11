package com.example.java_demo_test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.respository.RegisterDao;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

@RestController
public class RegisterController {
	
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterDao registerDao;

	@PostMapping(value = "add_register") 
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		
		return registerService.register(request.getAccount(), request.getPwd());
		
	}
	
	
	@PostMapping(value = "do_verify") 
	public RegisterResponse active(@RequestBody RegisterRequest request) {
		
		return registerService.active(request.getAccount(), request.getPwd());
		
	}
	
	@PostMapping(value = "log_in") 
	public RegisterResponse login(@RequestBody RegisterRequest request, HttpSession session) {
		
		RegisterResponse res = registerService.login(request.getAccount(), request.getPwd());
		if(res.getMessage().equalsIgnoreCase("Login Successful!")) {
			
			double random = Math.random() * 10000;
			int verifyCode = (int)Math.round(random);
			
			session.setAttribute("verifyCode", verifyCode);
			session.setAttribute("account", request.getAccount());
			session.setAttribute("pwd", request.getPwd());
			// 每60 秒重新生成一次
			session.setMaxInactiveInterval(60); // 單位: 秒
			
			
			res.setSessionId(session.getId());
			res.setVerifyCode(verifyCode);
		
		}
		
		return res;
	}
	
	
	@PostMapping(value = "get_date_time") 
	public RegisterResponse getRegTime(@RequestBody RegisterRequest request) {
		
//		Register reg = registerDao.findByAccountAndActive(account, pwd, true);
		return registerService.getRegTime(request.getAccount(), request.getPwd());
		
	}
	
	
	@PostMapping(value = "get_date_time2") 
	public RegisterResponse getRegTime2(@RequestBody RegisterRequest request, HttpSession session) {
		
		String account = (String)session.getAttribute("account");
		String pwd = (String)session.getAttribute("pwd");
		
//		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//			
//			return new RegisterResponse("Please login!!");
//		}
		
		// 認證代碼取得
		Integer verifyCode = (Integer)session.getAttribute("verifyCode");
//
//		
//		if(verifyCode == null || verifyCode != request.getVerifyCode()) {
//			
//			return new RegisterResponse("Verify code incorrect!!");
//
//		}
		
//		return registerService.getRegTime(account, pwd);
		return registerService.getRegTime2(request, account, pwd, verifyCode);
	}

}
