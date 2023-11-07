package com.example.shoppingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingservice.model.CustomerCart;
import com.example.shoppingservice.repository.CustomerCartRepository;

@RestController
@RequestMapping("/api/customer-cart")
public class CustomerCartController {
	
	@Autowired
    private CustomerCartRepository customerCartRepository;

	@PostMapping("/addCustomerCart")
    public ResponseEntity<?> addCustomerCart(@RequestBody CustomerCart customerCart) {
        customerCartRepository.save(customerCart);
        return ResponseEntity.ok("Customer-Cart mapping saved successfully");
    }
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}

}
