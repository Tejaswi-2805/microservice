package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.LineItem;


public interface LineItemService {

	List<LineItem> getAll();
	public LineItem addLineItem(LineItem lineItem);
	LineItem updateLineItem(int itemId, LineItem lineItem);
	Optional<LineItem> searchLineItem(int itemId);
	void deleteLineItem(int itemId);
}
