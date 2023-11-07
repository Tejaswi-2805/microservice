package com.example.shoppingservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.shoppingservice.model.Cart;
import com.example.shoppingservice.model.Customer;
import com.example.shoppingservice.model.CustomerCart;
import com.example.shoppingservice.model.Inventory;
import com.example.shoppingservice.model.Product;
import com.example.shoppingservice.model.ProductRequest;
import com.example.shoppingservice.repository.CustomerCartRepository;

@Service
public class CompositeMicroservice {

	@Autowired
	private CustomerCartRepository customerCartRepository;

	RestTemplate restTemplate = new RestTemplate();

	public ResponseEntity<?> createProductAndUpdateInventory(ProductRequest productRequest) {
		// Invoke Product Microservice to create a product using the rest template and url "http://localhost:9091/api/products/addproduct" and store the response in a variable of type Product class
		Product product = restTemplate.postForObject("http://localhost:9195/api/products/addproduct", productRequest, Product.class);
		int quantity=productRequest.getQuantity();

		// Create an Inventory object with the product ID and quantity.
		Inventory inventoryRequest = new Inventory(quantity,product.getProductId());

		// Invoke Inventory Microservice to update inventory with the generated product ID using the rest template and url "http://localhost:9092/api/inventory/addInv" and store the response in a variable of type String class
		Inventory inventoryResponse = restTemplate.postForObject("http://localhost:9195/api/inventory/addInv", inventoryRequest, Inventory.class);
		System.out.println(inventoryResponse);
		return ResponseEntity.ok("product created successfully");
	}

	//  method createCustomerAndCart to make a call to "http://localhost:9090/api/customers/addCustomer" to create a customer in Customer Microservice  and then make a call to "http://localhost:9093/api/cart/addCart" to create a cart in Cart Microservice
	public ResponseEntity<?> createCustomerAndCart(Customer customer){
		
		// Invoke Customer Microservice to create a customer using the rest template 
		//		and url "http://localhost:9090/api/customers/addCustomer"
		ResponseEntity<Customer> customerResponse = restTemplate.postForEntity("http://localhost:9090/api/customers/addCustomer", customer, Customer.class);
		Customer customerData = customerResponse.getBody();
		int customerId=customerData.getCustomerId();

		Cart cart = new Cart();
		ResponseEntity<Cart> cartResponse = restTemplate.postForEntity("http://localhost:9093/api/cart/addCart", cart, Cart.class);
		Cart createdCart = cartResponse.getBody();
		int cartId=createdCart.getCartId();

		// Saving the mapping between the customer & cart in Customer-Cart table
		CustomerCart customerCart = new CustomerCart();
		customerCart.setCartId(cartId);
		customerCart.setCustomerId(customerId);
		customerCartRepository.save(customerCart); 

		String response = "Created customer with ID: " + customerId + ", and cart with ID: " + cartId;
		return ResponseEntity.ok(response);    
	}

	
	public int getCartIdByCustomerId(int customerId) {
		// Invoke Customer Microservice to get the cart ID using the rest template and url mentioned above and store the response in a variable of type int
		Optional<CustomerCart> cart=customerCartRepository.findById(customerId);
		int cartId = cart.get().getCartId();
		return cartId;
	}

	public boolean addProductsToCart(int cartId, List<Product> products) {
		// Invoke Cart Microservice to add products to the cart using the rest template and url mentioned above and store the response in a variable of type boolean
		ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:9195/api/cart/addCart", products, Boolean.class);
		boolean responseBoolean = response.getBody();
		return responseBoolean;
	}
}
