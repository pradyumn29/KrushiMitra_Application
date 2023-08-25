package com.app.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Dto.DeleteUserDto;
import com.app.Dto.UserDto;

@Service
public interface UserService {
	UserDto AddNewUser(UserDto newUser);
	
	List<UserDto> getAllCustomer();
	List<UserDto> getAllSeller();
	UserDto updateExistingUser(UserDto updateUser);
	
	UserDto getUserByEmail(String userEmail);

	UserDto getUserById(Long userId);
	
	String deleteUser(DeleteUserDto deleteUser);


}
