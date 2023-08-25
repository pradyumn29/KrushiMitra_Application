package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.DeleteUserDto;
import com.app.Dto.UserDto;
import com.app.Service.User.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserDto newUser){
		
		return new ResponseEntity<>(userService.AddNewUser(newUser), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer")
	public List<UserDto> getCustomer() {
		return userService.getAllCustomer();
	}
	
	@GetMapping("/seller")
	public List<UserDto> getSeller() {
		return userService.getAllSeller();
	}
	
	@GetMapping("/{email}")
	public UserDto  getUserByMail(@PathVariable String email) {
		return userService.getUserByEmail(email);
		
	}
	
	@GetMapping("/{id}")
	public UserDto  getUserByMail(@PathVariable long id) {
		return userService.getUserById(id);
		
	}
	
	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody DeleteUserDto user) {
		String msg="user is not deleted";
		userService.deleteUser(user);
		
	}
	


}
