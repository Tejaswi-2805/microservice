package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	OrdersRepository oRepository;
	@Override
	public List<Orders> getAll() {
		List<Orders> orders=oRepository.findAll();
		return orders;
	}

	@Override
	public Orders addOrder(Orders orders) {
		Orders o=oRepository.save(orders);
		return o;
	}

	@Override
	public Orders updateorder(int orderId, Orders order) {
		Orders o1= oRepository.findById(orderId).get();
		o1.setLineItems(order.getLineItems());
		oRepository.save(o1);
		return o1;
	}

	@Override
	public Optional<Orders> searchorder(int orderId) {
		Optional<Orders> order = oRepository.findById(orderId);
		return order;
		
	}

	@Override
	public void deleteOrder(int orderId) {
		if(oRepository.existsById(orderId)){
			oRepository.deleteById(orderId);
		}
	}

}
