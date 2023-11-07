package com.example.shoppingservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
    private String customerName;
    private String customerEmail;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="billing_address_id")
    private Address customerBillingAddress;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shipping_address_id")
    private Address customerShippingAddress;
    
    
    
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Address getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(Address customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	public Address getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(Address customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String customerEmail, Address customerBillingAddress,
			Address customerShippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerBillingAddress=" + customerBillingAddress + ", customerShippingAddress="
				+ customerShippingAddress + "]";
	}
}
