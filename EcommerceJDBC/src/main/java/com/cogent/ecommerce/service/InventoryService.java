package com.cogent.ecommerce.service;

import java.util.Optional;

import com.cogent.ecommerce.model.Inventory;

public interface InventoryService {
	public String addInventory(Inventory inventory);
	public void deleteAll();
	public Optional<String> deleteProductById(String productId);
	public Inventory getInventoryById(String invId);
}
