package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {

}
