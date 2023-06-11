package com.example.data.jpa.mapper;

import com.example.data.jpa.dto.UserDto;
import com.example.data.jpa.entity.User;

public class UserMapper {
	
	public static User mapToUser(UserDto userDto) {
		
		return new User(userDto.getId(), 
								userDto.getFirstName(),
								userDto.getLastName(),
								userDto.getEmail());
	}
	
	public static UserDto mapToUserDto(User user) {
		
		return new UserDto(user.getId(), 
							user.getFirstName(),
							user.getLastName(),
							user.getEmail());
	}	

}
