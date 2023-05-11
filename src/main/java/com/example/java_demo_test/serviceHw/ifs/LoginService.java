package com.example.java_demo_test.serviceHw.ifs;

import java.util.List;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.vo.LoginResponse;

public interface LoginService {

	// Œš—§’ åj”»’è‰ñ™B(Vú)
	public LoginResponse addLoginData(List<Login> login);
	
	// é„æš
	public LoginResponse verifyTheData(String Account, String Pwd);
	
}
