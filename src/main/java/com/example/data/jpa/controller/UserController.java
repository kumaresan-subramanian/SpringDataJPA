package com.example.data.jpa.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.jpa.dto.UserDto;
import com.example.data.jpa.entity.User;
import com.example.data.jpa.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD REST API for User Resources",
		description = "Create, update, Read, Delete Users resource"
)
@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Operation(
			summary = "create user",
			description = "save user in database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP status created"
	)
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
		
		UserDto newUser = userService.createUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "get user",
			description = "read user from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status created"
	)
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id){
		
		UserDto user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@Operation(
			summary = "get All User",
			description = "read all user from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status created"
	)
	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUser(){
		
		List<UserDto> user = userService.findAll();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@Operation(
			summary = "update User",
			description = "update user in database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status created"
	)
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, 
			@RequestBody @Valid UserDto user){
		
		user.setId(id);
		UserDto newUser = userService.updateUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	} 
	
	@Operation(
			summary = "delete User",
			description = "update user in database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status created"
	)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		
		userService.deletUser(id);
		return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
	}
}
