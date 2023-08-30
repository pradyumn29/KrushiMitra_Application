package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.PlaceOrderDto;
import com.app.dto.SellerDto;
import com.app.dto.UpdatePriceDto;
import com.app.dto.Userdto;


import com.app.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class AdminController {
	
	@Autowired
	private IUserService userServices;
	

	
	@Autowired

	
	// Add a method to get all customer list
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomerList() {
		List<Userdto> listCustomer = userServices.getAllCustomer();
//		log.info("list :" + listCustomer.toString());
		return new ResponseEntity<>(listCustomer, HttpStatus.OK);
	}
	

	
	@PostMapping("/updateprice")
	public ResponseEntity<?> updatePrice(@RequestBody UpdatePriceDto updatePrice) {

		userServices.UpdateProdPrice(updatePrice);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

}
