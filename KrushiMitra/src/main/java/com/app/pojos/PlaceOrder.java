package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PlaceOrder extends BaseEntity {

	private int quantity;

	@OneToOne
	private Products product;

	private String notes;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

	@Enumerated(EnumType.STRING)
	private PlaceOrderStatus status;

	



	public PlaceOrder() {
		super();
		this.orderDate = LocalDate.now();
		this.status = PlaceOrderStatus.ORDER_PLACED;
	
	}

	public PlaceOrder(int quantity, Products product, String notes) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.notes = notes;
		this.orderDate = LocalDate.now();
		this.status = PlaceOrderStatus.ORDER_PLACED;
		
	}

	@Override
	public String toString() {
		return "PlaceOrder [quantity=" + quantity + ", notes=" + notes + ", orderDate=" + orderDate + ", status="
				+ status + ", supplierStatus="  + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public PlaceOrderStatus getStatus() {
		return status;
	}

	public void setStatus(PlaceOrderStatus status) {
		this.status = status;
	}


	

}
