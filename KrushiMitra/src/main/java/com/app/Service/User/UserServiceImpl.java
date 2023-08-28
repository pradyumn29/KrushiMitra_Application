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
		System.out.println(newUser.getFirstname());
	//	System.out.println(newUser.getAddress());
		System.out.println("hiii mohit");
//---------------------------map address n set adress to save----------------------------------------		
		Address add=mapper.map(newUser,Address.class);
		add.setId(newUser.getId());
		add.setAddressLine1(newUser.getAddressLine1());
		add.setAddressLine2(newUser.getAddressLine2());
		add.setCity(newUser.getCity());
		add.setCountry(newUser.getCountry());
		add.setHouse_number(newUser.getHouse_number());
		add.setPostalcode(newUser.getPostalcode());
		add.setState(newUser.getState());
		add.setStreet_number(newUser.getStreet_number());
		System.out.println(add);
		
		Address newAddress=addressRepo.save(add);
		//System.out.println(newAddress);
//------------------------------map	user and Save----------------------------------------------------------------	
		 User user=mapper.map(newUser, User.class);
		 user.setAddress(newAddress);
		 System.out.print(user);
//---------------------------------------save user---------------------------------------------------------------
		    User adduser=userRepo.save(user);
	    
		return mapper.map(adduser,UserDto.class);
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
		User Exstinguser=userRepo.findByEmail(updateUser.getEmail())
				            .orElseThrow(()->new UserHandlingException("Invalid Email entered"));
//-------------------------user update------------------------------------------------------------
		if(Exstinguser!=null) {
			Exstinguser.setFirstname(updateUser.getFirstname());
			Exstinguser.setLastname(updateUser.getLastname());
			//Exstinguser.setEmail(updateUser.getEmail());
			Exstinguser.setContactNumber(updateUser.getContactNumber());
			Exstinguser.setDOB(updateUser.getDOB());
			Exstinguser.setAge(updateUser.getAge());
			Exstinguser.setPassword(updateUser.getPassword());
		//	Exstinguser.setAddress(updateUser.getAddress());

//---------------------------Address update-------------------------------------------------------	
			Address add=mapper.map(updateUser,Address.class);
			add.setId(updateUser.getId());
			add.setAddressLine1(updateUser.getAddressLine1());
			add.setAddressLine2(updateUser.getAddressLine2());
			add.setCity(updateUser.getCity());
			add.setCountry(updateUser.getCountry());
			add.setHouse_number(updateUser.getHouse_number());
			add.setPostalcode(updateUser.getPostalcode());
			add.setState(updateUser.getState());
			add.setStreet_number(updateUser.getStreet_number());
			System.out.println(add);
//-----------------------saving address----------------------------------------------------------------
			Address newAddress=addressRepo.save(add);
//----------------------set new address to the mapped user class---------------------------------------			
			User user=mapper.map(Exstinguser,User.class);
			user.setAddress(newAddress);
	
//---------------------------------------save user----------------------------------------------------			
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
