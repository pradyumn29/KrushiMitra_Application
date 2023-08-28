package com.app.Controller;

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

import com.app.Dto.CartItemDto;
import com.app.Dto.RemoveCartItemDto;
import com.app.Service.CartItem.CartItemService;
import com.app.exceptions.ShoppingCartException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cartitem")
public class CartItemController {
	
	@Autowired
	private CartItemService cartService;
	
	@PostMapping("/addproduct")
	public void addProductToCart(@RequestBody CartItemDto product) throws ShoppingCartException{
		
		cartService.addProduct(product.getProducts(), product.getQuantity(), product.getCurUser());
	}
	
	@GetMapping("/cartitemlist/{id}")
	public ResponseEntity<?> cartItemList(@PathVariable Long id){
	
		return new ResponseEntity<>(cartService.listCartItems(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/emptyCart/{id}")
	public void deleteItem(@PathVariable Long id) {
		cartService.deleteByUser(id);
	}
	
	@DeleteMapping("/removeProdut")
	public void removeProduct(@RequestBody RemoveCartItemDto item) {
		cartService.removeProduct(item.getProducts(),item.getCurUser());
	}
	
	@GetMapping("/total/{id}")
	public double totalAmount(@PathVariable Long id) {
		return cartService.getTotalAmount(id);
	}

}
