package com.codewithmanish.blog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmanish.blog.Payloads.ApiResponse;
import com.codewithmanish.blog.Payloads.CategoryDto;
import com.codewithmanish.blog.Services.impl.CategoryServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("category/api")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
@PostMapping("/")
public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto){
	CategoryDto createdCategorys=this.categoryServiceImpl.createCategory(categoryDto);
	return new ResponseEntity<>(createdCategorys,HttpStatus.CREATED);
	}
@PutMapping("/{categoryId}")
public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId")Integer categoryid){
	CategoryDto updated=this.categoryServiceImpl.updateCategory(categoryDto, categoryid);
	return ResponseEntity.ok(updated);
}
@DeleteMapping("/{categoryId}")
public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
	this.categoryServiceImpl.deleteCategory(categoryId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("category is not found",false),HttpStatus.CREATED);
}
@GetMapping("/")
public ResponseEntity<List<CategoryDto>>getAllCategory(){
	return ResponseEntity.ok(this.categoryServiceImpl.getAllCategory());
}
}
