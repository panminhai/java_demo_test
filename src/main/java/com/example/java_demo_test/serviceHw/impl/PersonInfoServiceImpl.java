package com.example.java_demo_test.serviceHw.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.respository.PersonInfoDao;
import com.example.java_demo_test.serviceHw.ifs.PersonInfoService;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

// 使用Service去託管需要實作的內容
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	// 使用Dao連接數據庫
	@Autowired
	private PersonInfoDao personInfoDao; // personInfoDao:數據庫資料

	// 使用Responce回應外端結果
	@Override // personInfoList: 使用者輸入資訊
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfoList) {

		/* Step1:防呆檢查(不要有無效資料) */
		// Collection: List集合 isEmpty:檢查是否null or empty
		if (CollectionUtils.isEmpty(personInfoList)) {
			return new PersonInfoResponse("新增資料錯誤!");
		}

		/* Step2: 檢查List的每項資訊(PersonInfo) */
		/* 把外端資料(非無效數據)放入ids的空list中 */
		List<String> ids = new ArrayList<>();
		for (PersonInfo item : personInfoList) {
			// 檢查id
//			if(!StringUtils.hasText(item.getId())) {
//				return new PersonInfoResponse("新增資訊錯誤!");	
//			}
//			
//			if(!StringUtils.hasText(item.getName())){
//				return new PersonInfoResponse("新增名稱錯誤");
//			}
//			
//			if(!StringUtils.hasText(item.getCity())){
//				return new PersonInfoResponse("新增城市錯誤");
//			}
//			
//			if(item.getAge() < 0) {
//				return new PersonInfoResponse("新增年齡錯誤");
//			}

			// 檢查是否為無效數據
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())
					|| !StringUtils.hasText(item.getCity()) || item.getAge() < 0) {
				return new PersonInfoResponse("新增資料錯誤!");

			}
			// 收集ID至空List字串(ids)
			ids.add(item.getId());
		}

		/* 檢查新增的ids是否存在(確認是否有重複數據) */
		// res: 數據庫(personInfoDao)裡有包含和ids資料相同的集合
		List<PersonInfo> res = personInfoDao.findAllById(ids);
		if (res.size() > 0) {
//			return new PersonInfoResponse("新增資料已存在!");

			List<String> resIds = new ArrayList<>();
			for (PersonInfo item : res) {
				// 從res擷取Id數據至resIds
				resIds.add(item.getId());

			}
			//
			List<PersonInfo> saveList = new ArrayList<>();
			for (PersonInfo item : personInfoList) { // A, B, C, D, E
				if (!resIds.contains(item.getId())) { // resIds = C, D
					saveList.add(item);
				}
			}

			// save:
			personInfoDao.saveAll(saveList);
			return new PersonInfoResponse("新增資料成功!");
		}

		// saveAll
		personInfoDao.saveAll(personInfoList);
		return new PersonInfoResponse(personInfoList, "新增資料成功!");

	}

	@Override
	public GetPersonInfoResponse getPersonInfoById(String id) {
		// 防呆(null, 空字串, 空白)
		if (!StringUtils.hasText(id)) {
			return new GetPersonInfoResponse("id不得為空");
		}
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if (!op.isPresent()) {
			return new GetPersonInfoResponse("資料不存在!");
		}

		return new GetPersonInfoResponse(op.get(), "成功!");
	}

	@Override
	public GetPersonInfoResponse getAllPersonInfo() {
		// 取得資料庫所有資訊
		List<PersonInfo> allData = personInfoDao.findAll();

		if (CollectionUtils.isEmpty(allData)) {

			return new GetPersonInfoResponse("新增資料錯誤!");
		}

		return new GetPersonInfoResponse(allData, "全部資料完成回傳");
	}

	/* 練習用: findId */ // id: 外端要求回應資料集的對象(Id)
	@Override
	public GetPersonInfoResponse getPersonInfoById2(String id) {

		if (!StringUtils.hasText(id)) {
			return new GetPersonInfoResponse("資料庫id為空!");
		}

		// 對象Id是否存在資料庫
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if (!op.isPresent()) {
			return new GetPersonInfoResponse("資料庫不存在此id!");
		}

		return new GetPersonInfoResponse(op.get(), "資料上傳成功!");
	}

	@Override
	public GetPersonInfoResponse getAgefindPerson(int age) {
		List<PersonInfo> findAge = personInfoDao.findByAgeGreaterThan(age);

//		for(PersonInfo item : findAge) {
//			item.getAge();
//		}
		// 防呆
		if (age < 0) {
			return new GetPersonInfoResponse("年齡錯誤!");
		}
		
		if(findAge.size() < 0) {
			return new GetPersonInfoResponse("請輸入資料!");
		}

		return new GetPersonInfoResponse(findAge, "資料上傳成功!");
	}

	@Override
	public GetPersonInfoResponse getAgeLessEqualPerson(int age) {

		
		return null;
	}

}
