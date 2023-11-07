package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String Hello() {
		return "HELLO";
	}
	
	@GetMapping("/getall")
	List<Customer> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable int customerId) {
		Optional<Customer> customer=customerService.getCustomer(customerId);
		return customer;
	}
	@PostMapping("/addCustomer")
	Customer addCustomer(@RequestBody Customer customer ) {
		Customer c = customerService.addCustomer(customer);
		return c;
	}

	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer updatedCustomer) {
		Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.ok().build();
	}
}
