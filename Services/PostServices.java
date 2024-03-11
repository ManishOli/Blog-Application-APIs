package com.codewithmanish.blog.Services;

import java.util.List;

import com.codewithmanish.blog.Payloads.PostDto;
import com.codewithmanish.blog.entity.Post;

public interface PostServices {

	
	PostDto createPost(PostDto postDto, Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto,int postId);
	PostDto getByIdPost(int postId);
	List<PostDto> getAllPost();
	void deletePost(int postId);
	
	
	
	List<PostDto> getPostByCategory(int categoryId);
	List<PostDto> getPostByUser(int userId);
	
	List<PostDto> searchAllPost(String keyword);
	
}
	
