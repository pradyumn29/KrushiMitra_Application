package com.app.Service.Order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Dto.OrderDto;
import com.app.Entities.Orders;

@Service
public interface OrderService {
	//customer
	Orders getOrders(Long id);
	
	String PlaceOrder(Long CustId);
	
	List<Orders> getOrdersByUserId(Long userId);
	
//	String DecreaseStock()

}
