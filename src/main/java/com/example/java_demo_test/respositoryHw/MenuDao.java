package com.example.java_demo_test.respositoryHw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entityHw.Menu;
/*
 * �����a�����ɓI�A�ڍa��
 */
// Jpa~<�ޕʖ�, �W����"ID"�I���������^��>
@Repository
public interface MenuDao extends JpaRepository<Menu, String>{
	
//	public void orderSystem(); 
}
