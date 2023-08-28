package com.app.Dto;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.app.Entities.Address;
import com.app.Entities.Product;
import com.app.Entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreType
public class OrderDto {

	private Long user;
	
	private Long products;
	
	@CreationTimestamp
	private LocalDate orderDate;

	private LocalDate deliveryDate;
	
	private int quantity;
	
	private double TotalPrice;
	private String PaymentId;

	private Long DeliveryAddress;
}
