package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Inventory;

public interface InventoryService {
	List<Inventory> getInventories();
	public Inventory addInventory(Inventory inventory);
	Inventory updateInventory(int inventoryId,Inventory inventory);
	Optional<Inventory> searchInventory(int inventoryId);
	void deleteInventory(int inventoryId);

}
