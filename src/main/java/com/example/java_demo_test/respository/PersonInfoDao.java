package com.example.java_demo_test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.PersonInfo;

/*
 * ›“’‰—˜a‘—¿ŒÉ(MySQL)“I˜AÚ
 */

@Repository //Ÿd—Ş‰—Repository•ÀŒğ‹‹Spring Boot‘õŠÇ 
// JpaRepository< Entity–¼, İ’è¬åkey(ID)“I‘—¿Œ^‘Ô–¼ >
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	/*
	 * ˆÀåäJpa”»•Ê®
	 */
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	
	// Hw
	public List<PersonInfo> findByAgeLessThanEqualOrderByAgeAsc(int age);
	
	public List<PersonInfo> findByAgeBetween(int fromAge, int toAge);
	
	public List<PersonInfo> findByAgeLessThanOrNameGreaterThan(int age1, int age2);
		
	public List<PersonInfo> findByCityContaining(String str);
	
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String str);
	
	


		
	
	
	

}
