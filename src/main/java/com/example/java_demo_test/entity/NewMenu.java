package com.example.java_demo_test.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "new_menu")
public class NewMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private int seq;
	
	
	@Column(name = "category")
	private String category;
	
	
	@Column(name = "item")
	private String item;
	
	
	@Column(name = "price")
	private int price;

	@Column(name = "uuid")
	@Type(type = "uuid-char")
	private UUID uuid = UUID.randomUUID();
	
	public NewMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NewMenu(int seq, String category, String item, int price, UUID uuid) {
		super();
		this.seq = seq;
		this.category = category;
		this.item = item;
		this.price = price;
		this.uuid = uuid;
	}


	public NewMenu(String category, String item, int price, UUID uuid) {
		super();
		this.category = category;
		this.item = item;
		this.price = price;
		this.uuid = uuid;
	}


	public NewMenu(int seq, String category, String item, int price) {
		super();
		this.seq = seq;
		this.category = category;
		this.item = item;
		this.price = price;
	}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int sea) {
		this.seq = sea;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
