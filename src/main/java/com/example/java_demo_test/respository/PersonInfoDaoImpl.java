package com.example.java_demo_test.respository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.PersonInfo;

//public List<PersonInfo> doQueryByAge(int age);
//
//public List<PersonInfo> doQueryByAge(int age, int limitSize);

//public List<PersonInfo> doQueryByAge(int age, int limitSize);




public class PersonInfoDaoImpl extends BaseDao{

	public List<PersonInfo> doQueryByAge(int age){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select P from PersonInfo P where P.age >= :age");
		
		Map<String, Object> params = new HashMap<>();
		params.put("age", params);
		return doQuery(sb.toString(), params, PersonInfo.class);
	}
	
	
	public List<PersonInfo> doQueryByAge(int age, int limitSize){
		StringBuffer sb = new StringBuffer();
		sb.append("select P from PersonInfo P where P.age >= :age");
		
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize);
	}

	
	public List<PersonInfo> doQueryByAge(int age, int limitSize, int startPosition){
		StringBuffer sb = new StringBuffer();
		sb.append("select P from PersonInfo P where P.age >= :age");
		
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);
		return doQuery(sb.toString(), params, PersonInfo.class, limitSize);
	}
	
	public int doUpdateAgeByName(int age, String name) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("update PersonInfo set age = :age where name = :name");
		Map<String, Object> params = new HashMap<>();
		params.put("age", age);
		params.put("name", name);

		
		
		return doUpdate(sb.toString(), params);
	}

	
}
