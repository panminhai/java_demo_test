package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.vo.BankResponse;

/*
 * BankService: 建立抽象"addInfo"方法
 */
public interface BankService {
	
	public void addInfo(Bank bank) ;
	
	// 取得資料庫(mySQL)裡account對應的amount值
	public Bank getAmount(String id) ;
	
	// 存款需要指定帳號, 密碼
	public BankResponse deposit(Bank bank);
	
	
	public BankResponse withdraw(Bank bank);
	
}
