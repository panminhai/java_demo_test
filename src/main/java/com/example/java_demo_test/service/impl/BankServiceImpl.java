package com.example.java_demo_test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.respository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

/*
 * 資料處理後啟用bankDao去接觸並存入數據庫(斷點確認)
 */

// 實作介面"BankService"
@Service
public class BankServiceImpl implements BankService {

	private String pattern = "\\w{3,8}";
	// 密碼防呆(字母正規表達來源: 教科書13-22)
	private String patternPwd = "[A-Za-z]{2}\\d{3}";
	// 密碼防呆(教師答案)
	private String patternPwd1 = "[\\w~!@#$%&*]{8,16}";

	// Autowired: 請Springboot託管BankDao的資料() 
	// 不需要建構式(~new~)就能使用註釋@service的物件
	@Autowired
	private BankDao bankDao;

	@Override
	public void addInfo(Bank bank) {
		/* TODO Auto-generated method stub */
		// 防呆設置: 1.帳號長度:3~8, 2.帳號不能有空白, 3.帳號不能有符號(~!@#$%&*)
		// 防呆1
		if (!bank.getAccount().matches(pattern) || bank.getAccount().isBlank()) {

			System.out.println("帳號錯誤!!!請輸入帳號");
			return;
		}
		// balance: 餘額防呆
		if (bank.getAmount() < 0 || bank.getAccount() == null) {
			System.out.println("餘額錯誤!!!請輸入餘額");
			return;
		}

		// 密碼防呆
		if (!bank.getPwd().matches(patternPwd)) {
			System.out.println("密碼錯誤!!!");
			return;
		}

		// 新增資料到bank這張表
		bankDao.save(bank);
	}

	@Override
	public Bank getAmount(String id) {
		// 確認Amount內容是否包含文字
		if (!StringUtils.hasText(id)) {

			return new Bank();
		}

		// Optional:確認是否為null值 // 找資料(有標記@id的資料)
		Optional<Bank> op = bankDao.findById(id);
		
		// optional的回傳值為"false", 就回傳至"new Bank"
		return op.orElse(new Bank());
		// 確認Optional的結果後就回傳
//		if(!op.isPresent())
//		{
//			return new Bank();
//		}
//		// id是空直or
//		if(id == null || id.isBlank())
//		{
//			return new Bank();
//		}
//		
//		return op.get();
//		// return bank;
//		}
	}

	@Override
	// 存款
	public BankResponse deposit(Bank bank) {
//		if (bank == null) {
//			return new Bank();
//		}
		// 若String裡面為
//		if (!StringUtils.hasText(bank.getAccount())) {
//			return new Bank();
//		}
//
//		if (!StringUtils.hasText(bank.getPwd())) {
//			return new Bank();
//		}
//
//		if (bank.getAmount() <= 0) {
//			return new Bank();
//		}
		// Bank資料中有1個以上為空值的情況下
		if (!StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd()) || bank.getAmount() <= 0) {
			return new BankResponse();
		}
		
//		Optional<Bank> op = bankDao.findById(bank.getAccount());
//		if(!op.isPresent()) {
//			return new Bank();
//		}
		
//		Bank resBank = op.get();
		
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if(resBank == null) {
			// 回傳一個空值Bank類別
			return new BankResponse();
		}
		
		// 從接收器(resBank)抽取出餘額(Amount)的值
		int oldAmount = resBank.getAmount();
		int depositAmount = bank.getAmount();
		// 原本金額+存款金額
		int newAmount = oldAmount + depositAmount;
		
		//設定存款後的金額
		resBank.setAmount(newAmount);
		
		// 把存完的資料用新變數(Bank)接回去
//		Bank newBank = bankDao.save(resBank);
//		return newBank;
		
		return new BankResponse(bankDao.save(resBank), "資料儲存成功!!!");
	}
	
	@Override
	public BankResponse withdraw(Bank bank) {
		if (!StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd()) || bank.getAmount() <= 0) {
			return new BankResponse(new Bank(), "帳號或密碼錯誤!!!");
		}
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if(resBank == null) {
			// 回傳一個空值Bank類別
			return new BankResponse(new Bank(), "資料不存在!!!");
		}
		
		int oldAmount = resBank.getAmount();
		int withDraw = bank.getAmount();
		
		int balAmount = oldAmount - withDraw;
		// 防呆設置: 
		if(balAmount < 0) {
			
			System.out.println("withdraw error!!!");
			return new BankResponse(new Bank(), "Withdraw isn't enoungh!!!"); 
		}
		
		resBank.setAmount(balAmount);
		
		
		return new BankResponse(bankDao.save(resBank), "提款成功!!!");
		
	}
	
	

}

