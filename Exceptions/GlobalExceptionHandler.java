package com.codewithmanish.blog.Exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithmanish.blog.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFoundExceptionHandling(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse api=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		
		}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String,String>respo=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			respo.put(fieldName, message);
		});
		return new ResponseEntity<>(respo,HttpStatus.BAD_REQUEST);
	}

}
