package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
