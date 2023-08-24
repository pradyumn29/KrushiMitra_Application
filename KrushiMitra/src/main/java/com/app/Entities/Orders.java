package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@JsonIgnoreType

public class Orders extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="Customer_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Product products;
	@NotNull
	private LocalDate orderDate;
	@NotNull
	private LocalDate deliveryDate;
	@NotNull
	private String OrderStatus;
	@NotNull
	private int quantity;
	@NotNull
	private double TotalPrice;
	@NotNull@NotBlank
	private String PaymentId;
	
	@OneToOne
	@JoinColumn(name="Address_id")
	private Address DeliveryAddress;
	
	

}
