package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Cart;
import com.example.demo.model.LineItem;


public interface CartService {
	List<Cart> getAll();
	public Cart addCart(LineItem lineItem);
	Cart updateCart(int cartId, Cart cart);
	Optional<Cart> searchCart(int cartId);
	ResponseEntity<?> emptyCart(int cartId);
}
