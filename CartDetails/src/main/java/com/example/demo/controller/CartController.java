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

import com.example.demo.model.Cart;
import com.example.demo.model.LineItem;
import com.example.demo.service.CartService;



@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
		
	//	post method to add cart 
	@PostMapping("/addCart")
	public Cart addCart(@RequestBody LineItem lineItem) {
		return cartService.addCart(lineItem);
	}

	// delete http method /cart/{cartId} deletes cart details based on id
	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> emptyCart(@PathVariable int cartId) {
		cartService.emptyCart(cartId);
		System.out.println("deleted successfully");
		return ResponseEntity.ok("deleted successfully");
	}

	// create a get http method /cart/{cartId} This api is mapped to searchCart method of CartService class
	@GetMapping("/{cartId}")
	public Optional<Cart> searchCart(@PathVariable int cartId) {
		return cartService.searchCart(cartId);
	}

// get method to get all cart details
	@GetMapping
	public List<Cart> getAll() {
		return cartService.getAll();
	}
	
	// put method to update cart details
	@PutMapping("/{cartId}")
	  public Cart updateCart(@PathVariable int cartId, @RequestBody Cart cart) {
	    return cartService.updateCart(cartId, cart);
	  }

}
