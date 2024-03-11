package com.codewithmanish.blog.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import com.codewithmanish.blog.Services.impl.post;
import com.codewithmanish.blog.entity.Category;
import com.codewithmanish.blog.entity.Post;
import com.codewithmanish.blog.entity.User;

public  interface PostRepo extends JpaRepository<Post,Integer>{

	List<Post> findByCategory(Category category);
	List<Post> findByUser(User user);,

}
