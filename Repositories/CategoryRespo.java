package com.codewithmanish.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmanish.blog.entity.Category;

public interface CategoryRespo extends JpaRepository<Category,Integer> {

}
