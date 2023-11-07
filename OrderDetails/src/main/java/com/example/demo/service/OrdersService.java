package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Orders;


public interface OrdersService {
	List<Orders> getAll();
	public Orders addOrder(Orders orders);
	Orders updateorder(int orderId, Orders order);
	Optional<Orders> searchorder(int orderId);
	void deleteOrder(int orderId);
}
