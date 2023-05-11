package com.example.java_demo_test.entityHw;

//persistence: ‘—¿‰i‹v‰»(‘¶“ü‘—¿ŒÉ)
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* mySQL‚Æ‚Ì˜AŒgİ’u*/
@Entity
@Table(name = "menu")

public class Menu {
	@Id
	@Column(name = "food")
	private String food;

	@Column(name = "price")
	private int price;

//	private int quantity;
//	
//	public int getQuantity() {
//		return quantity;
//	}



//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}



	public Menu() {

	}
	
	

	public Menu(String food, int price) {
		super();
		this.food = food;
		this.price = price;
	}



	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public String getItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
