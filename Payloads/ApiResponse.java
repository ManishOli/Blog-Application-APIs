package com.codewithmanish.blog.Payloads;



public class ApiResponse {
	
	public String message;
	public boolean success;

	 public ApiResponse(String message, boolean success) {
	        this.message = message;
	        this.success = success;
	    }
}
