package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Catalog;

public interface CatalogRepository {
	public String addInventory(Catalog catalog);
	public void deleteAll();
	public String deleteCatalogById(String productId);
	public Optional<Catalog> getCatalogById(String catId);

}
