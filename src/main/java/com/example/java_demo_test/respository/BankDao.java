package com.example.java_demo_test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.PersonInfo;

/*
 * 保存動作
 */

//<T>: type　專注於和資料庫(SQL)的連接溝通
// データベースと保存に関わる：Repository(データベース(SQL)とのやり取りだけ専念している)
@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	
	// 用於對照資料庫(MySQL)的account和pwd值是否存在
	public Bank findByAccountAndPwd(String account, String pwd);
	
	
}

