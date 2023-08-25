package com.app.Service.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.DeleteUserDto;
import com.app.Dto.UserDto;
import com.app.Entities.Address;
import com.app.Entities.Role;
import com.app.Entities.User;
import com.app.Repository.AddressRepo;
import com.app.Repository.UserRepo;
import com.app.exceptions.UserHandlingException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public UserDto AddNewUser(UserDto newUser) {
	   Address address=newUser.getAddress();
	   addressRepo.save(address);
	   
	   User user=mapper.map(newUser, User.class);
	    User adduser=userRepo.save(user);
	    
		return mapper.map(adduser, UserDto.class);
	}

	@Override
	public List<UserDto> getAllCustomer() {
	   
		List<User> userList=userRepo.findByRole(Role.CUSTOMER);
		List<UserDto>userDtoList=new ArrayList<UserDto>();
		
		for(User list:userList) {
			userDtoList.add(mapper.map(list,UserDto.class));
		}
		return userDtoList;
	}

	@Override
	public List<UserDto> getAllSeller() {
		
		List<User> userList=userRepo.findByRole(Role.SELLER);
		List<UserDto>userDtoList=new ArrayList<UserDto>();
		
		for(User list:userList) {
			userDtoList.add(mapper.map(list,UserDto.class));
		}
		return userDtoList;
	}

	@Override
	public UserDto updateExistingUser(UserDto updateUser) {
		User user=userRepo.findByEmail(updateUser.getEmail())
				            .orElseThrow(()->new UserHandlingException("Invalid Email entered"));
		
		if(user!=null) {
			user.setFirstname(updateUser.getFirstname());
			user.setLastname(updateUser.getLastname());
			user.setEmail(updateUser.getEmail());
		    user.setContactNumber(updateUser.getContactNumber());
		    user.setDOB(updateUser.getDOB());
		    user.setAge(updateUser.getAge());
		    user.setPassword(updateUser.getPassword());
		    user.setAddress(updateUser.getAddress());
		    User updatedUser=userRepo.save(user);
		    
		    return mapper.map(updatedUser, UserDto.class);
		}else {
			throw new UserHandlingException("Invalid Email");
		}
	}

	@Override
	public UserDto getUserByEmail(String userEmail) {
	Optional<User> user=userRepo.findByEmail(userEmail);

		return mapper.map(user,UserDto.class);
	}

	@Override
	public UserDto getUserById(Long userId) {
	  User user=userRepo.findById(userId).orElseThrow(()->new UserHandlingException("Invalid Id entered"));
		return mapper.map(user,UserDto.class);
	}

	@Override
	public String deleteUser(DeleteUserDto deleteUser) {
		String msg="user not deleted";
		User user=userRepo.findByEmail(deleteUser.getEmail()).orElseThrow(()->new UserHandlingException("Invalid Email entered"));
		if(deleteUser.getPassword().matches(user.getPassword())) {
			userRepo.deleteById(user.getId());
			msg="user deleted!!!";
		}
		return msg;
	}

}
