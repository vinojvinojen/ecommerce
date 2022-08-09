package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Category;
import com.ecommerce.repos.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}



	public List<Category> getAllCate() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}



	public void editCate(int categoryId, Category updateCate) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.getById(categoryId);
		category.setCategoryName(updateCate.getCategoryName());
		category.setDescription(updateCate.getDescription());
		category.setImageUrl(updateCate.getImageUrl());
		categoryRepository.save(category);

	}



	public boolean findById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId).isPresent();
	}
}
