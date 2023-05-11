package com.example.java_demo_test.serviceHw.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.GetPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

public interface PersonInfoService {
	// PersonInfoResponse: �ݒu������B�^�� //method���@	// ():request�I�����ޕ�
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfo) ;
	
	// Response:�ʏ퐥��"Set"�����request
	public GetPersonInfoResponse getPersonInfoById(String id);

	public GetPersonInfoResponse getAllPersonInfo();
	
	// ���K�pmethod
	public GetPersonInfoResponse getPersonInfoById2(String id);
	
	// ���4
	public GetPersonInfoResponse getAgefindPerson(int age);

	// ���5
	public GetPersonInfoResponse getAgeLessEqualPerson(int age);
	
	
		


	
}
