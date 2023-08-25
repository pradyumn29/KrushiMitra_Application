package com.app.Service.CartItem;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.CartItem;
import com.app.Entities.Product;
import com.app.Entities.User;
import com.app.Repository.CartItemRepo;
import com.app.Repository.UserRepo;
import com.app.Service.Product.ProductService;
import com.app.exceptions.ShoppingCartException;
import com.app.exceptions.UserHandlingException;
@Service
@Transactional
public class CartItemImpl implements CartItemService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductService prodService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CartItemRepo cartRepo;
	

	@Override
	public void addProduct(Long productId, int quantity, Long customerId) throws ShoppingCartException {
		     int  updatedQuantity=quantity;
	         User user=userRepo.findById(customerId).orElseThrow(()->new UserHandlingException("Invalid Id entered"));
	         Product prod=prodService.getProductById(productId);
	         
	         CartItem cartItem=new CartItem();
	         if(cartItem!=null) {
	        	 updatedQuantity = cartItem.getQuantity() + quantity;
	        	 if (updatedQuantity < 0) {
						throw new UserHandlingException("Invalid quantity");
					}
	         }
                 cartItem.setCurUser(user);
                 cartItem.setProducts(prod);
                 cartItem.setQuantity(updatedQuantity);
               
                 cartRepo.save(cartItem);
	}

	@Override
	public List<CartItem> listCartItems(Long Custid) {
	//   User customer=userRepo.findById(Custid).orElseThrow(()->new UserHandlingException("Invalid Id entered"));
	   return cartRepo.findByCurUser(Custid);
	     
	}

	@Override
	public void deleteByUser(Long id) {
		
	}

	@Override
	public void removeProduct(Long productId, Long customerId) {
	 
	Product prod=prodService.getProductById(productId);
	User customer=userRepo.findById(customerId).orElseThrow();
	
	cartRepo.deleteByCurUserAndProducts(customerId, productId);

	}

	@Override
	public double getTotalAmount(Long CustId) {
		double totalAmount = 0.00;
		List<CartItem> cartItems = listCartItems(CustId);
		for (CartItem cartItem : cartItems) {
			totalAmount+=cartItem.getTotalOfProduct();
		}
		return totalAmount;
	}

}
