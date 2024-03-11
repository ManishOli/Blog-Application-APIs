package com.codewithmanish.blog.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.profile.Fetch;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private Integer categoryId;
    @Column(name = "category_name", nullable = false, length = 100)
 private String categoryName;
 private String categoryTitle;
 
 @OneToMany(mappedBy="category" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 
 public List<Post> cateories=new ArrayList<>();
 
public Category() {

}
public Category(Integer categoryId, String categoryName, String categoryTitle) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.categoryTitle = categoryTitle;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
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
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryTitle=" + categoryTitle
			+ "]";
}



 
}
