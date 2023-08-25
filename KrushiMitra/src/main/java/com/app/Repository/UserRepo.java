package com.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Role;
import com.app.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
  
	List<User>findByRole(Role role);
	
	Optional<User>findByEmail(String email);

 
}
