package com.example.shoppingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_cart")
public class CustomerCart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private int customerId;
	private int cartId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public CustomerCart(int id, int customerId, int cartId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.cartId = cartId;
	}
	public CustomerCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
