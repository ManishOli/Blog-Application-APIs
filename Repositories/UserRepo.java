package com.codewithmanish.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmanish.blog.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
