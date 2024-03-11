package com.codewithmanish.blog.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithmanish.blog.Payloads.UserDto;
@Service
public interface UserServices {
   
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
