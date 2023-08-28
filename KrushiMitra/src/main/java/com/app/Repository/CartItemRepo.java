package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.Entities.CartItem;
import com.app.Entities.User;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {
    
	List<CartItem> findByCurUser(User userId);
    
    @Modifying
	@Query("DELETE FROM CartItem c WHERE c.curUser.id = ?1 AND c.products.id = ?2")
	void deleteByCurUserAndProducts(Long customerId, Long productId);
}
