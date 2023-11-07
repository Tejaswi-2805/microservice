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

import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/getAllInv")
	List<Inventory> getAllInventories(){
		List<Inventory> i = inventoryService.getInventories();
		return i;
	}
	
	@GetMapping("/searchInv/{inventoryId}")
	Optional<Inventory> addInventory(@PathVariable int inventoryId) {
		Optional<Inventory> inv = inventoryService.searchInventory(inventoryId);
		return inv;
	}
	@PostMapping("/addInv")
	Inventory addInventory(@RequestBody Inventory inventory) {
		Inventory i = inventoryService.addInventory(inventory);
		return i;
	}
	@PutMapping("/updateInv/{inventoryId}")
	public ResponseEntity<Inventory> updateInv(@PathVariable int inventoryId, @RequestBody Inventory updatedInventory) {
		Inventory updated = inventoryService.updateInventory(inventoryId, updatedInventory);
		return ResponseEntity.ok(updated);
	}
	@DeleteMapping("/deleteInv/{inventoryId}")
	public ResponseEntity<Void> deleteInv(@PathVariable int inventoryId) {
		inventoryService.deleteInventory(inventoryId);
		return ResponseEntity.ok().build();
	}
}
