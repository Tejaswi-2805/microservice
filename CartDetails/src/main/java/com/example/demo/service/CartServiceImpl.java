package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.Cart;
import com.example.demo.model.LineItem;
import com.example.demo.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	@Override
	public List<Cart> getAll() {
		List<Cart> carts=cartRepository.findAll();
		return carts;
	}

	// provide add cart method
	public Cart addCart(LineItem lineItem2) {
//		Cart c1=cartRepository.save(cart);
//		return ResponseEntity.ok(c1);

		Cart cart=new Cart();
//		for(LineItem lineItem2:lineItem) {
			lineItem2.setProductId(lineItem2.getProductId());
			System.out.println(lineItem2);
			lineItem2.setProductName(lineItem2.getProductName());
			lineItem2.setQuantity(lineItem2.getQuantity());
			lineItem2.setPrice(lineItem2.getPrice());
			cart.getLineItems().add(lineItem2);

//		}
//		return cartRepository.save(cart);
//		lineItem.setProductId(lineItem.getProductId());
//		System.out.println(lineItem);
//		lineItem.setProductName(lineItem.getProductName());
//		lineItem.setQuantity(lineItem.getQuantity());
//		lineItem.setPrice(lineItem.getPrice());
//		
//		cart.getLineItems().add(lineItem);
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(int cartId, Cart cart) {
		Cart c1=cartRepository.findById(cartId).get();
		c1.setLineItems(cart.getLineItems());
		return c1;
	}

	@Override
	public Optional<Cart> searchCart(int cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		return cart;
	}

	@Override
	public ResponseEntity<?> emptyCart(int cartId) {
		// TODOR Auto-generated method stub
		if(cartRepository.existsById(cartId)) {
			cartRepository.deleteById(cartId);
		}
		return ResponseEntity.ok("deleted");
	}

}
