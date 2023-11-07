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

import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;

@RestController
@RequestMapping("/api/order")
public class OrdersContoller {
	
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/getAll")
	List<Orders> getAll(){
		List<Orders> orders=ordersService.getAll();
		return orders;
	}
	
	@PostMapping("/addOrder")
	Orders orders(@RequestBody Orders o) {
		Orders orders = ordersService.addOrder(o);
		return orders;
	}
	@GetMapping("/getOrder/{orderId}")
	public Optional<Orders> searchOrder(@PathVariable int orderId){
		Optional<Orders> o = ordersService.searchorder(orderId);
		return o;
	}
	@PutMapping("/updateOrder/{orderId}")
	Orders Update(@PathVariable int orderId, @RequestBody Orders updatedorder) {
		Orders c1=ordersService.updateorder(orderId, updatedorder);
		return c1;
	}
	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<Orders> deleteOrders(@PathVariable int orderId) {
		ordersService.deleteOrder(orderId);
		return ResponseEntity.ok().build();
	}

}
