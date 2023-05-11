package com.example.java_demo_test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.respository.PersonInfoDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class PersonInfoTest {
	
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void updateNameById() {
		// ret=1: ����	ret=0: ���s
		int ret = personInfoDao.updateNameById("B01", "BBB", 20, "宜蘭");
		System.out.println("����:" + ret);
	
	}
	
	@Test
	public void updateAgeByNameTest() {
	
		int res = personInfoDao.doUpdateAgeByName(38, "A01_name");
		System.out.println(res);
	
	
	}

	
	@Test
	public void findAllByNameOrCity() {
		List<PersonInfo> res = personInfoDao.findAllByNameOrCity(".");
		
		// 找出"name"和"city"裡有包含"市"的資料欄位
		List<PersonInfo> res1 = personInfoDao.findAllByNameOrCity("市");
//		System.out.println(res.size());

		for(PersonInfo item: res) {
			
			System.out.println("" + item.getName());
			System.out.println("" + item.getCity());
			System.out.println("");
		}

		System.out.println("");

		
		for(PersonInfo item: res1) {
			
			System.out.println("" + item.getName());
			System.out.println("" + item.getCity());
			System.out.println("");


		}
	}
	

	
	
}
