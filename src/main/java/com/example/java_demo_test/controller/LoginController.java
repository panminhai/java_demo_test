package com.example.java_demo_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.serviceHw.ifs.LoginService;
import com.example.java_demo_test.vo.LoginRequest;
import com.example.java_demo_test.vo.LoginResponse;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "add_Login_Data")
	public LoginResponse addLoginData(@RequestBody LoginRequest request) {
		
		return loginService.addLoginData(request.getLogin());
	}
	
	@PostMapping(value =  "Verify_The_Data")
	public LoginResponse verifyTheData(@RequestBody LoginRequest request) {
		
		return loginService.verifyTheData(request.getAccount(), request.getPwd());
	}
	

}
