package com.ecommerce.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.common.ApiResponse;
import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/add/cate")
	public ResponseEntity<ApiResponse> addCate(@RequestBody Category category) {
		categoryService.addCategory(category);
		return new ResponseEntity<>(new ApiResponse(true, "created"),HttpStatus.CREATED);
	}
	
	@GetMapping("/cate/list")
	public List<Category> getAllCate() {
		return categoryService.getAllCate();
		 
	}
	
	@PutMapping("/updateCaet/{categoryId}")
	public ResponseEntity<ApiResponse> updateByCate(@PathVariable("categoryId") int categoryId,@RequestBody Category category) {
		
		if(!categoryService.findById(categoryId)){
			return new ResponseEntity<>(new ApiResponse(false, "id not found"),HttpStatus.NOT_FOUND);

		}
		categoryService.editCate(categoryId,category);

		return new ResponseEntity<>(new ApiResponse(true, "updated"),HttpStatus.OK);
		 
	}

}
