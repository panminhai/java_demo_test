package com.example.java_demo_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.respository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

//在跑以下的測試程式時都會做"Test"標記

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class BankTest {
/*
 * データベースに入力
 */
	@Autowired
	private BankDao bankDao;
	
	// Autowired: 不需要建構式(~new~)就能使用註釋@service的物件
	@Autowired
	private BankService bankService;

	private String pattern;
	
	
	
	
	@Test
	public void addBankInfo() {
		Bank bank = new Bank("A06", "aa131", 1900);	//(呼叫類別ank)填入資料: 虛擬資料 

//		Bank bank2 = new Bank("A03", "AA125", 2000);
		
		bankService.addInfo(bank);	// 呼叫介面"BankService"的方法把輸入資料丟給類別"BankServiceImpl"處理
//		bankService.addInfo(bank2);
	}
	@Test	
	public void addInfoTest() {
		Bank bank1 = new Bank(null, "AA123", 2000);
		bankService.addInfo(bank1);
	}
	// 存款處理方法
	@Test
	public void depositTest() {
//		Bank bank1 = new Bank(null, "AA123", 2000);
		Bank oldBank = bankDao.save(new Bank("AA01", "AA123", 1000));
		
		// 存款
		Bank newBank = new Bank("AA01", "AA123", 3000);
		BankResponse response = bankService.deposit(newBank);
		
		Bank resBank = response.getBank();
		// 確認金額有進去// assert
		Assert.isTrue(resBank.getAmount() == (oldBank.getAmount() + newBank.getAmount()), "存款錯誤!!!");
		// 存款資料刪除
//		bankDao.delete(resBank);
		//		addInfoTest();
	}
	// 提款處理方法
	@Test
	public void withdrawTest() {
		
		Bank oldBank = bankDao.save(new Bank("WA01", "WA123", 5000));
		
		Bank newBank = (new Bank("WA01", "WA123", 6000));
		
		BankResponse response = bankService.withdraw(newBank);
		
		Bank resBank = response.getBank();
		// 顯示錯誤警告(無法擋住執行)
		Assert.isTrue(resBank.getAmount() == (oldBank.getAmount() - newBank.getAmount()), "提款錯誤!!!");
		Assert.isTrue(response.getMessage().equals("提款成功!!!"), "提款失敗!!!");

		
		
		
		
		
	}
	
//	public void getAmountByIdTest() {
//		
//	}
	
//	@Test
//	public void addBankInfo() {
//		Bank bank = new Bank("A03", "AA125", 2000);
//		
//	}
		
		
//	if(!op.isPresent()) {
//		return new Bank();
//	}
//	Bank resBank = op.get();
		

		// 新增資料到bank這張表
//		bankDao.save(bank);
		
	

}
