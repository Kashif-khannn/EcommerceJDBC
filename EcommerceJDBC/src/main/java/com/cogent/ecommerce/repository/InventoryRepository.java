package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Inventory;
import com.cogent.ecommerce.model.Orders;

public interface InventoryRepository {
	public String addInventory(Inventory inventory);
	public void deleteAll();
	public Optional<String> deleteProductById(String productId);
	public Inventory getInventoryById(String invId);

}
