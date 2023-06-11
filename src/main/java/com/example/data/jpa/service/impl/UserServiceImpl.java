package com.example.data.jpa.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.jpa.dto.UserDto;
import com.example.data.jpa.entity.User;
import com.example.data.jpa.exception.EmailAlreadyExistsException;
import com.example.data.jpa.exception.ResourceNotFoundException;
import com.example.data.jpa.mapper.UserMapper;
import com.example.data.jpa.repository.UserRepository;
import com.example.data.jpa.service.UserService;

import lombok.AllArgsConstructor;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		Optional<User> opUser = userRepository.findByEmail(userDto.getEmail());
		if(opUser.isPresent()) {
			throw new EmailAlreadyExistsException("User Email Already Exists");
		}
		User user = userRepository.save(modelMapper.map(userDto, User.class));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto findById(Long id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> findAll() {
		
		List<User> userList = userRepository.findAll();
		return userList.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		
		User fetchUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		fetchUser.setFirstName(user.getFirstName());
		fetchUser.setLastName(user.getLastName());
		fetchUser.setEmail(user.getEmail());
		User newUser = userRepository.save(fetchUser);
		return modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public void deletUser(Long id) {
		User fetchUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
	}
	
	

}
