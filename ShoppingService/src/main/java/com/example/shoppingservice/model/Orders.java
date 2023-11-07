package com.example.shoppingservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "orders")
//	private List<LineItem> lineItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

//	public List<LineItem> getLineItems() {
//		return lineItems;
//	}
//
//	public void setLineItems(List<LineItem> lineItems) {
//		this.lineItems = lineItems;
//	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + "]";
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


}
