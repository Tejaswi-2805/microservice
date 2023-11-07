package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id",referencedColumnName = "cartId")
	List<LineItem> lineItems=new ArrayList<>();
	
//	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, orphanRemoval = true)

	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		return "Cart [cartId=" + cartId + ", lineItems=" + lineItems + "]";
//	}
//	public Cart(int cartId) {
//		super();
//		this.cartId = cartId;
//	}
//	
//	 public void addLineItem(LineItem lineItem) {
//	        lineItems.add(lineItem);
//	        lineItem.setCart(this);
//	    }
//
//	    public void removeLineItem(LineItem lineItem) {
//	        lineItems.remove(lineItem);
//	        lineItem.setCart(null);
//	    }
		
}
