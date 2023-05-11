package com.example.java_demo_test.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.PersonInfo;

/*
 * õìíçâóòaéëóøå…(MySQL)ìIòAê⁄
 */

@Repository //üdóﬁâóRepositoryï¿åããSpring Bootëıä« 
// JpaRepository< Entityñº, ê›íËê¨éÂkey(ID)ìIéëóøå^ë‘ñº >
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	/*
	 * à¿Â‰Jpaîªï éÆ
	 */
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	
	// Hw
	public List<PersonInfo> findByAgeLessThanEqualOrderByAgeAsc(int age);
	
	public List<PersonInfo> findByAgeBetween(int fromAge, int toAge);
	
	public List<PersonInfo> findByAgeLessThanOrNameGreaterThan(int age1, int age2);
		
	public List<PersonInfo> findByCityContaining(String str);
	
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String str);
	

	
	public List<PersonInfo> doQueryByAge(int age);

	public List<PersonInfo> doQueryByAge(int age, int limitSize);

	public List<PersonInfo> doQueryByAge(int age, int limitSize, int startPosition);

	@Transactional
	public int doUpdateAgeByName(int age, String name);

	
	// è„â€îÕó·(jpql)
	@Transactional
	@Modifying
	@Query("update PersonInfo p set p.id = :newId, p.name = :newName "
			+",p.age = :newAge, p.city = :newCity where p.id = :newId")
	public int updateNameById(
			@Param("newId") String inputId,
			@Param("newName") String inputName, 
			@Param("newAge") int inputAge, 
			@Param("newCity") String inputCity);
	/*
	 * 1. ç™ùüõ{ê∂ìIID --> ùùèoäYõ{ê∂
	 */
//	@Query("select c from Course C where id in (select s.courseCode from Student S where id =: inputId)")
//	public List<Course> findCourseByCode(@Param("inputId") String inputId){
//		
//	}

	
	// find all data
	@Transactional
	@Modifying
	@Query(value = "select * from person_info p where p.name or p.city regexp :inputRegexp", nativeQuery = true)
	public List<PersonInfo> findAllByNameOrCity(@Param("inputRegexp")String str);

	
	
	@Transactional
	@Modifying
	@Query(value = "select * from person_info p where p.name or p.city regexp :inputRegexp", nativeQuery = true)
	public List<PersonInfo> getNothing(@Param("inputRegexp")String str);

		



	}
