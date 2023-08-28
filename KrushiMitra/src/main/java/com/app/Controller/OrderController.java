package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.OrderDto;
import com.app.Entities.Orders;
import com.app.Service.Order.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	

	@GetMapping("/Order/{id}")
	public Orders viewOrders(@PathVariable Long id) {
		
		return orderService.getOrders(id);
	}
	
	@PostMapping("/placeOrder/{id}")
	public ResponseEntity<?> placeOrder(@PathVariable Long id){
		
		return new ResponseEntity<>(orderService.PlaceOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("orderList/{id}")
	public List<Orders> orderList(@PathVariable Long UserId){
		
		return orderService.getOrdersByUserId(UserId);
	}

}
