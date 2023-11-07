package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	Customer updateCustomer(int customerId, Customer customer);
	List<Customer> getAllCustomers();
	Optional<Customer> getCustomer(int customerId);
	void deleteCustomer(int customerId);
	
}
