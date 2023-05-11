package com.example.java_demo_test;

import java.util.UUID;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.NewMenu;
import com.example.java_demo_test.respository.NewMenuDao;


@SpringBootTest(classes = JavaDemoTestApplication.class)
public class NewMenuTest {
	
	@Autowired
	private NewMenuDao newMenuDao;
	
	@Test
	public void addDataTest() {
		NewMenu num1 = new NewMenu("fish", "ê˜", 100, UUID.randomUUID());
		
		newMenuDao.save(num1);
//		newMenuDao.saveAll(Arrays.asList(num1));

	}

}
