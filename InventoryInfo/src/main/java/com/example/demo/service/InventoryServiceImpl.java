package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository iRepository;
	
	@Override
	public Inventory addInventory(Inventory inventory) {
		Inventory inv=iRepository.save(inventory);
		return inv;
	}

	@Override
	public Inventory updateInventory(int inventoryId, Inventory updateInventory) {
		// TODO Auto-generated method stub
		Inventory i = iRepository.findById(inventoryId).get();
		i.setProductId(updateInventory.getProductId());
		i.setQuantity(updateInventory.getQuantity());
		iRepository.save(i);
		return i;
	}

	@Override
	public Optional<Inventory> searchInventory(int inventoryId) {
		// TODO Auto-generated method stub
		Optional<Inventory> inventory=iRepository.findById(inventoryId);
		return inventory;
	}

	@Override
	public void deleteInventory(int inventoryId) {
		// TODO Auto-generated method stub
		if(iRepository.existsById(inventoryId)) {
			iRepository.deleteById(inventoryId);
		}
	}

	@Override
	public List<Inventory> getInventories() {
		// TODO Auto-generated method stub
		List<Inventory> elist = iRepository.findAll();
		return elist;
	}
}
