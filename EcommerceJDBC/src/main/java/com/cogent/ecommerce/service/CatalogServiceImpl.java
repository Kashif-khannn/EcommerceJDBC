package com.cogent.ecommerce.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Catalog;
import com.cogent.ecommerce.repository.CatalogRepository;
@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	CatalogRepository catalogRepository;
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		catalogRepository.deleteAll();
		
	}

	

	@Override
	public String addInventory(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.addInventory(catalog);
	}

	@Override
	public String deleteCatalogById(String productId) {
		// TODO Auto-generated method stub
		return catalogRepository.deleteCatalogById(productId);
	}

	@Override
	public Optional<Catalog> getCatalogById(String catId) {
		// TODO Auto-generated method stub
		return catalogRepository.getCatalogById(catId);
	}

}
