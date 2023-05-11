package com.example.java_demo_test.respositoryHw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entityHw.Menu;
/*
 * ›“’˜a‘—¿ŒÉ“I˜AÚa’Ê
 */
// Jpa~<—Ş•Ê–¼, •W’ˆ×"ID"“I›¢«‘—¿Œ^‘Ô>
@Repository
public interface MenuDao extends JpaRepository<Menu, String>{
	
//	public void orderSystem(); 
}
