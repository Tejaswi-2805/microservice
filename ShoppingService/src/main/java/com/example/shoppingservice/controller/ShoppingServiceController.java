package com.example.shoppingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingservice.model.Customer;
import com.example.shoppingservice.model.Product;
import com.example.shoppingservice.model.ProductRequest;
import com.example.shoppingservice.service.CompositeMicroservice;

@RestController
@RequestMapping("/api/shoppingservice")
public class ShoppingServiceController {

	@Autowired
	private CompositeMicroservice compositeMicroservice;

	//post method to invoke product microservice to create product and would invoke Inventory Micro Service
	//	with productid generated from previous call & updates the inventory information
	@PostMapping("/products")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
		compositeMicroservice.createProductAndUpdateInventory(productRequest);
		return ResponseEntity.ok("product is created successfully and inventory is updated");
	}

	//	post method to invoke Customer Microservice to create a customer & invoke Cart Service 
	//	to create an empty cart for new customer
	@PostMapping("/customer")
	public ResponseEntity<?> createCustomerAndCart(@RequestBody Customer customer) {
		compositeMicroservice.createCustomerAndCart(customer);
		return ResponseEntity.ok("customer details are created successfully and respective  ");
	}

	@PutMapping("/customer/{customerId}/cart")
	public ResponseEntity<?> addToCart(@PathVariable int customerId,@RequestBody List<Product> products){
		// Check if the customer exists and fetch the cartId from the Customer-Cart table
		int cartId = compositeMicroservice.getCartIdByCustomerId(customerId);

		// Invoke Cart Service to add the products to the cart
		boolean success = compositeMicroservice.addProductsToCart(cartId, products);

		if (success) {
			return ResponseEntity.ok("Products added to the cart successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add products to the cart");
		}
	}

}


