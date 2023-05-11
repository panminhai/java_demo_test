package com.example.java_demo_test.serviceHw.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.GetPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

public interface PersonInfoService {
	// PersonInfoResponse: İ’u‘—¿‰ñ™BŒ^‘Ô //method•û–@	// ():request“I‘—¿—Ş•Ê
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfo) ;
	
	// Response:’Êí¥ˆÈ"Set"‹‰ñœärequest
	public GetPersonInfoResponse getPersonInfoById(String id);

	public GetPersonInfoResponse getAllPersonInfo();
	
	// —ûK—pmethod
	public GetPersonInfoResponse getPersonInfoById2(String id);
	
	// ì‹Æ4
	public GetPersonInfoResponse getAgefindPerson(int age);

	// ì‹Æ5
	public GetPersonInfoResponse getAgeLessEqualPerson(int age);
	
	
		


	
}
