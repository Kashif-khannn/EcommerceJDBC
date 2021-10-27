package com.cogent.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Category;
import com.cogent.ecommerce.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public String addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.addCategory(category);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		categoryRepository.deleteAll();
	}

	@Override
	public String deleteCategoryById(String catId) {
		// TODO Auto-generated method stub
		return categoryRepository.deleteCategoryById(catId);
	}

	@Override
	public Optional<Category> getCategoryById(String catId) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryById(catId);
	}

}
