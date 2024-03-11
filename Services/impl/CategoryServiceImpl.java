package com.codewithmanish.blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmanish.blog.Exceptions.ResourceNotFoundException;
import com.codewithmanish.blog.Payloads.CategoryDto;
import com.codewithmanish.blog.Repositories.CategoryRespo;
import com.codewithmanish.blog.Services.CategoryServices;
import com.codewithmanish.blog.entity.Category;

import jakarta.validation.Valid;

@Service
public class CategoryServiceImpl implements CategoryServices {
	@Autowired
	CategoryRespo categoryRespo;
	
	@Override
	public CategoryDto createCategory( CategoryDto categoryDto) {
		Category category=dtoToCategory(categoryDto);
		Category categorySaved=this.categoryRespo.save(category);
		return this.categoryToDto(categorySaved);
	}
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categorysId) {
	 Category category=this.categoryRespo.findById(categorysId).orElseThrow(()-> new ResourceNotFoundException("Category","int",categorysId));
	 category.setCategoryId(categoryDto.getId());
		category.setCategoryName(categoryDto.getCategoryName());
		category.setCategoryTitle(categoryDto.getCategoryTitle());

	 return this.categoryToDto(category);
	}
	public  List<CategoryDto>getAllCategory(){
		 List<Category> category=this.categoryRespo.findAll();
		 List<CategoryDto> categoryDto=category.stream().map(cat->this.categoryToDto(cat)).collect(Collectors.toList());
		 return categoryDto;
	 }
	public CategoryDto getCategoryById(Integer categorysId) {
		Category category=this.categoryRespo.findById(categorysId).orElseThrow(()-> new ResourceNotFoundException("Category","int",categorysId));
		return this.categoryToDto(category);
	}
	@Override
	public void deleteCategory(Integer categorysId) {
		Category category=this.categoryRespo.findById(categorysId).orElseThrow(()-> new ResourceNotFoundException("Category","int",categorysId));
		 this.categoryRespo.delete(category);
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category=new Category();
		category.setCategoryId(categoryDto.getId());
		category.setCategoryName(categoryDto.getCategoryName());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		return category;
		
		}
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto=new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setCategoryTitle(category.getCategoryTitle());
		return categoryDto;
	}

}
