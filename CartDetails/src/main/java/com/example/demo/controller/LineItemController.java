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

import com.example.demo.model.LineItem;
import com.example.demo.service.LineItemService;

@RestController
@RequestMapping("/api/lineitems")
public class LineItemController {

	@Autowired
	LineItemService lineItemService;
	
	@GetMapping("/getAll")
	public List<LineItem> getAll(){
		List<LineItem> lineItems=lineItemService.getAll();
		return lineItems;
	}
	
	@PostMapping("/addItem")
	LineItem lineItem(@RequestBody LineItem lineItem) {
		LineItem l = lineItemService.addLineItem(lineItem);
		return l;
	}
	@GetMapping("/getItem/{itemId}")
	public Optional<LineItem> searchLineItem(@PathVariable int itemId){
		Optional<LineItem> line = lineItemService.searchLineItem(itemId);
		return line;
	}
	@PutMapping("/updateItem/{itemId}")
	LineItem UpdateItem(@PathVariable int itemId, @RequestBody LineItem updatedLineItem) {
		LineItem item=lineItemService.updateLineItem(itemId, updatedLineItem);
		return item;
	}
	@DeleteMapping("/deleteItem/{itemId}")
	public ResponseEntity<LineItem> deleteItem(@PathVariable int itemId) {
		lineItemService.deleteLineItem(itemId);
		return ResponseEntity.ok().build();
	}
	
}
