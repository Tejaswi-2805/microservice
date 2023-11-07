package com.example.shoppingservice.model;

public class ProductRequest {
	private int productId;
	 public ProductRequest(int productId, String productName, String productDescription, float productPrice,
			int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	private String productName;
	    private String productDescription;
	    private float productPrice;
	    private int quantity;
	    
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		@Override
		public String toString() {
			return "ProductRequest [productId=" + productId + ", productName=" + productName + ", productDescription="
					+ productDescription + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
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
}
