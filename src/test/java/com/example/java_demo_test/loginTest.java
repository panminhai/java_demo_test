package com.example.java_demo_test;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.respository.LoginDao;



@SpringBootTest(classes = JavaDemoTestApplication.class)
public class loginTest {
	
	
	@Autowired
	private LoginDao logDao;
	
	@Autowired
	private LocalDateTime regTime;

	
	@Test
	public void addLoginData() {
		
		// String account, String pwd, String name, int age, String city
		Login data = new Login("A01", "ab12345", "AAA", 20, "‘ä–k", regTime,true);
		
		logDao.save(data);
	}

}
