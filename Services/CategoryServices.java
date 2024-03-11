package com.codewithmanish.blog.Services;

import java.util.List;

import com.codewithmanish.blog.Payloads.CategoryDto;

public interface CategoryServices {

	CategoryDto createCategory(CategoryDto category);
	CategoryDto updateCategory(CategoryDto category,Integer categorysId);
	 List<CategoryDto>getAllCategory();
	CategoryDto getCategoryById(Integer categorysId);
	 void deleteCategory(Integer categoryId);
	
}
