package com.example.shoppingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProductId;
	private String productName;
	private String productDescription;
	private float productPrice;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public Product(int productId, String productName, String productDescription, float productPrice) {
		super();
		ProductId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + "]";
	}
	
}
