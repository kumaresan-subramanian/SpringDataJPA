package com.example.data.jpa.service;

import java.util.List;

import com.example.data.jpa.dto.UserDto;
import com.example.data.jpa.entity.User;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto findById(Long id);
	
	List<UserDto> findAll();
	
	UserDto updateUser(UserDto user);
	
	void deletUser(Long id);
	
}
