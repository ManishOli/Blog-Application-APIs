package com.codewithmanish.blog.Services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codewithmanish.blog.Exceptions.ResourceNotFoundException;
import com.codewithmanish.blog.Payloads.PostDto;
import com.codewithmanish.blog.Payloads.UserDto;
import com.codewithmanish.blog.Repositories.CategoryRespo;
import com.codewithmanish.blog.Repositories.PostRepo;
import com.codewithmanish.blog.Repositories.UserRepo;
import com.codewithmanish.blog.Services.PostServices;
import com.codewithmanish.blog.entity.Category;
import com.codewithmanish.blog.entity.Post;
import com.codewithmanish.blog.entity.User;


//PostServiceImpl class
@Service
public class PostServiceImpl implements PostServices{
 @Autowired
 private PostRepo postRepo;

 @Autowired
 private UserRepo userRepo;

 @Autowired
 private CategoryRespo categoryRepo;

 @Autowired
 private ModelMapper modelMapper;

 @Override
      public PostDto createPost(PostDto postDto, Integer userId,Integer categoryId) {
	 User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
		Category category =this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Cateogry","Category id",categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	 
     // Your implementation here
 }


	public Post dtoToPost(PostDto postDto) {
		
	
		Post post=this.modelMapper.map(postDto,Post.class);
		/*
		Post post=new Post();
		post.setPostId(postDto.getPostId());
		post.setContent(postDto.getContent());
		post.setPostTitle(postDto.getPostTitle());
		post.setDate(postDto.getDate());
		post.setImageName(postDto.getImageName());
		*/
		return post;
		
	}
	public PostDto postToDto(Post post) {
		
		PostDto postDto=this.modelMapper.map(post, PostDto.class);
		/*
		PostDto postDto=new PostDto();
		postDto.setPostId(post.getPostId());
		postDto.setContent(post.getContent());
		postDto.setPostTitle(post.getPostTitle());
		postDto.setDate(post.getDate());
		postDto.setImageName(post.getImageName());
		*/
		return postDto;
		
	}


	@Override
	public PostDto updatePost(PostDto postDto, int postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","int",postId));
		
		post.setPostId(postDto.getPostId());
		post.setContent(postDto.getContent());
		post.setPostTitle(postDto.getPostTitle());
		post.setDate(postDto.getDate());
		post.setImageName(postDto.getImageName());
		
		Post posst=this.postRepo.save(post);
		return this.modelMapper.map(posst,PostDto.class);
		
		
		
	}


	@Override
	public PostDto getByIdPost(int postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","int",postId));
		return this.modelMapper.map(post, PostDto.class);
	}


	@Override
	public List<PostDto> getAllPost() {
		List<Post> allPost=this.postRepo.findAll();
		List<PostDto> posted=allPost.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return posted;
	}


	@Override
	public void deletePost(int postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","int",postId));
		this.postRepo.delete(post);
		
	}


	@Override
	public List<PostDto> getPostByCategory(int categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","int",categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


	@Override
	public List<PostDto> getPostByUser(int userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("USer","int",userId));
		List<Post> posts=this.postRepo.findByUser(user);
		
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
	
		return postDtos;
	}


	@Override
	public List<PostDto> searchAllPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
