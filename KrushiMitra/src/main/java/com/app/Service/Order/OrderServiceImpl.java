package com.app.Service.Order;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.CartItem;
import com.app.Entities.Orders;
import com.app.Entities.User;
import com.app.Repository.CartItemRepo;
import com.app.Repository.OrderRepo;
import com.app.Repository.ProductRepo;
import com.app.Repository.UserRepo;
import com.app.Service.CartItem.CartItemService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CartItemRepo cartRepo;
	@Autowired
	private CartItemService cartService;

	@Override
	public Orders getOrders(Long id) {
		
		return orderRepo.findById(id).orElseThrow();
	}

	@Override
	public String PlaceOrder(Long CustId) {
		String msg="order is not placed";
		
		User user=userRepo.findById(CustId).orElseThrow();
		List<CartItem>cartList=cartService.listCartItems(CustId);
	     Orders newOrder=new Orders();
	     List<Orders> OrderDetails=new ArrayList<Orders>();
	     Double total=0.0;
	     
		if(user!=null) {
			
			for(CartItem c: cartList) {
			
				newOrder.setDeliveryAddress(c.getCurUser().getAddress());
				newOrder.setProducts(c.getProducts());
				newOrder.setQuantity(c.getQuantity());
				newOrder.setUser(c.getCurUser());
				total+=c.getTotalOfProduct();
				newOrder.setTotalPrice(total);
				OrderDetails.add(newOrder);
				
				//delete product from cart after placing order
				cartRepo.deleteByCurUserAndProducts(user.getId(),c.getProducts().getId());

				
			}
			//System.out.println(OrderDetails);
			//Orders order=mapper.map(placeOrder, Orders.class);
			orderRepo.save(OrderDetails);
			
			msg="order placed";
		}		
		
		return msg;
	}

	@Override
	public List<Orders> getOrdersByUserId(Long userId) {
		User user=userRepo.findById(userId).orElseThrow();
		return orderRepo.findByUser(userId);
	}

}
