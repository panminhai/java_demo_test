package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.serviceHw.ifs.PersonInfoService;
import com.example.java_demo_test.vo.AddPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;


@RestController
public class PersonInfoController {

	// Service端回應給前端訊息
	@Autowired
	private PersonInfoService personInfoService;
	
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "add_person_info") 
	public PersonInfoResponse addPersonInfo(@RequestBody AddPersonInfoRequest request) {
		
		return personInfoService.addPersonInfo(request.getResPersonInfo());

	}
	// 查詢資料庫使用:和外端對應的資料				
	@PostMapping(value = "get_person_info_by_id")
	public GetPersonInfoResponse getPersonInfoById(@RequestBody GetPersonInfoRequest request) {
		
		return personInfoService.getPersonInfoById(request.getId());
	
	}
	
	@PostMapping(value = "getAllData")
	public GetPersonInfoResponse getAllPersonInfo() {
		
		return personInfoService.getAllPersonInfo();
		
	}
	
	@PostMapping(value = "findId2")
	public GetPersonInfoResponse getPersonInfoById2(@RequestBody GetPersonInfoRequest request) {
		
		return personInfoService.getPersonInfoById2(request.getId());
	}
	

	@PostMapping(value = "findAge")				// "()"內容為外端的request對象("age":)的呼叫
	public GetPersonInfoResponse getAgefindPerson(@RequestBody AddPersonInfoRequest request){
		
		return personInfoService.getAgefindPerson(request.getAge()); 
	}

	@PostMapping(value = "findLessAge")
	public GetPersonInfoResponse getAgeLessEqualPerson(@RequestBody AddPersonInfoRequest request){
			
			return personInfoService.getAgefindPerson(request.getAge()); 
		}

	
}
