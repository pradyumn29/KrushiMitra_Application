package com.app.Service.CartItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Entities.CartItem;
import com.app.exceptions.ShoppingCartException;

@Service
public interface CartItemService {

	void addProduct(Long productId, int quantity, Long customerId) throws ShoppingCartException;
	
	List<CartItem> listCartItems(Long id);

	void deleteByUser(Long id);

	void removeProduct(Long productId, Long customerId);

	double getTotalAmount(Long id);
}
