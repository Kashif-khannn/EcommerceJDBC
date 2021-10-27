package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Category;

public interface CategoryRepository {
	public String addCategory(Category category);
	public void deleteAll();
	public String deleteCategoryById(String catId);
	public Optional<Category> getCategoryById(String catId);

}
