package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer c = repository.save(customer);
		return c;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer c1= repository.findById(customerId).get();
		
		int addressId=c1.getCustomerBillingAddress().getAddressId();
		customer.getCustomerBillingAddress().setAddressId(addressId);
		
		int addressId1=c1.getCustomerShippingAddress().getAddressId();
		customer.getCustomerShippingAddress().setAddressId(addressId1);
		
		c1.setCustomerId(customerId);
		c1.setCustomerName(customer.getCustomerName());
		c1.setCustomerEmail(customer.getCustomerEmail());
		c1.setCustomerBillingAddress(customer.getCustomerBillingAddress());
		c1.setCustomerShippingAddress(customer.getCustomerShippingAddress());
		
        repository.save(c1);
		return c1;
	}
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> eList = repository.findAll();
		return eList;
	}

	@Override
	public Optional<Customer> getCustomer(int customerId) {
		Optional<Customer> customer=repository.findById(customerId);
		return customer;
	}
	@Override
	public void deleteCustomer(int customerId) {
		if(repository.existsById(customerId)) {
			repository.deleteById(customerId);
		}
	}
}
