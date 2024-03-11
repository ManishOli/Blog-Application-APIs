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
import com.codewithmanish.blog.Payloads.PostDto;
import com.codewithmanish.blog.Services.PostServices;
import com.codewithmanish.blog.entity.Post;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	PostServices postService;
	
	@PostMapping("/users/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			                                       @PathVariable Integer userId,@PathVariable Integer categoryId){
		   postDto.setPostTitle("YourNonNullableTitle");  // Set a non-null value for PostTitle
	        postDto.setContent("YourContent");
		PostDto createPost=this.postService.createPost(postDto,userId,categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto postDtoo=this.postService.updatePost(postDto,postId);
		return new ResponseEntity<PostDto>(postDtoo,HttpStatus.OK);
		
	}
	
		@GetMapping("/post")
		public ResponseEntity<List<PostDto>> getAllPost(){
			List<PostDto> allPost=this.postService.getAllPost();
			return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);

		
		}
		@DeleteMapping("/{postId}")
		public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
			this.postService.deletePost(postId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Post Not Found",true),HttpStatus.OK);
		}
		
		@GetMapping("/post/{postId}")
		public ResponseEntity<PostDto> getByIdPost(@PathVariable Integer postId){
			PostDto postDtoo=this.postService.getByIdPost(postId);
			return new ResponseEntity<PostDto>(postDtoo,HttpStatus.OK);
			
		
		}
		
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto>posts=this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}

	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto> posts=this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
}
