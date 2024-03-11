package com.codewithmanish.blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmanish.blog.Exceptions.*;
import com.codewithmanish.blog.Payloads.UserDto;
import com.codewithmanish.blog.Repositories.UserRepo;
import com.codewithmanish.blog.Services.UserServices;
import com.codewithmanish.blog.entity.User;
@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
    public UserDto createUser(UserDto userDto) {
		
		User user=dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}
	
	@Override
	public UserDto updateUser(UserDto userDto,Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","int",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		user=dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}
	@Override 
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","int",userId));
		return this.userToDto(user);
		
	}
	
	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","int",userId));
		 this.userRepo.delete(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>users=this.userRepo.findAll();
		List<UserDto>userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	
	}
	
	public User dtoToUser(UserDto userDto) {
	User user=this.modelMapper.map(userDto,User.class );
	/*  Integer userId = userDto.getId();
	    if (userId != null) {
	        user.setId(userId.intValue());
	    }

	user.setId(userDto.getId());
	if (userDto.getName() != null) {
        user.setName(userDto.getName());
    }
	user.setName(userDto.getName());
	user.setEmail(userDto.getEmail());
	user.setPassword(userDto.getPassword());
	user.setAbout(userDto.getAbout());*/
	return user;
	
	}
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		/*userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());*/
		return userDto;
	}
}
