package com.codewithmanish.blog.Payloads;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
	
	public Integer categoryId;
	@NotBlank
    @Size(min=4,message="User must put min 4 characters")
	public String categoryName;
	@NotBlank
    @Size(min=6,max=20 ,message="Username must be min of 6 and max 20 characters")
	public String categoryTitle;
	public CategoryDto(Integer categoryId, String categoryName, String categoryTitle) {
		super();
		categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryTitle = categoryTitle;
	}
	
	@Override
	public String toString() {
		return "CategoryDto [Id=" + categoryId + ", categoryName=" + categoryName + ", categoryTitle=" + categoryTitle + "]";
	}

	public Integer getId() {
		return categoryId;
	}
	public void setId(Integer id) {
		categoryId = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public CategoryDto(){
		
	}
	
	
	

}
