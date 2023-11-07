package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lineitems")
public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String productId;
    private String productName;
    private int quantity;
    private double price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Orders_id")
    private Orders orders;
    
	public LineItem(int itemId, String productId, String productName, int quantity, double price, Orders Orders) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orders = Orders;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders Orders) {
		this.orders = Orders;
	}	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", Orders=" + orders + "]";
	}
//	public LineItem(int itemId, String productId, String productName, int quantity, double price) {
//		super();
//		this.itemId = itemId;
//		this.productId = productId;
//		this.productName = productName;
//		this.quantity = quantity;
//		this.price = price;
//	}
//	@Override
//	public String toString() {
//		return "LineItem [itemId=" + itemId + ", productId=" + productId + ", productName=" + productName
//				+ ", quantity=" + quantity + ", price=" + price + "]";
//	}
	

}
