package com.cogent.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Inventory;
import com.cogent.ecommerce.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepository inventoryRepository;
	@Override
	public String addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.addInventory(inventory);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		inventoryRepository.deleteAll();
		
	}

	@Override
	public Optional<String> deleteProductById(String productId) {
		// TODO Auto-generated method stub
		return inventoryRepository.deleteProductById(productId);
	}

	@Override
	public Inventory getInventoryById(String invId) {
		// TODO Auto-generated method stub
		return inventoryRepository.getInventoryById(invId);
	}

}
