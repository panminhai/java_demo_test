package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_info")

// PersonInfo: 將資料庫每項資訊包裝成一筆資料
public class PersonInfo {
	@Id
	@Column(name = "id") // Column():呼叫資料庫資料
	private String id; // 資料庫資料

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "city")
	private String city;
	
	
	// 預設建構方法
	public PersonInfo() {
		super();
	}
	// 4種參數整合成一筆資料
	public PersonInfo(String id, String name, int age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
