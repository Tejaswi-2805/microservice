package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LineItem;
import com.example.demo.repository.LineItemRepository;

@Service
public class LineItemServiceImpl implements LineItemService{
	
	@Autowired
	LineItemRepository repositoy;

	@Override
	public List<LineItem> getAll() {
		List<LineItem> lineItems=repositoy.findAll();
		return lineItems;
	}

	@Override
	public LineItem addLineItem(LineItem lineItem) {
		LineItem lItem=repositoy.save(lineItem);
		return lItem;
	}

	@Override
	public LineItem updateLineItem(int itemId, LineItem lineItem) {
		LineItem l1=repositoy.findById(itemId).get();
		l1.setProductId(lineItem.getProductId());
		l1.setProductName(lineItem.getProductName());
		l1.setQuantity(lineItem.getQuantity());
		l1.setPrice(lineItem.getPrice());
		repositoy.save(l1);
		return l1;
	}

	@Override
	public Optional<LineItem> searchLineItem(int itemId) {
		Optional<LineItem> line = repositoy.findById(itemId);
		return line;
	}

	@Override
	public void deleteLineItem(int itemId) {
		// TODO Auto-generated method stub
		if(repositoy.existsById(itemId)) {
			repositoy.deleteById(itemId);
		}
	}

}
