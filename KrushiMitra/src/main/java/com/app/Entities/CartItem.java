package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Cart_Items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreType
public class CartItem extends BaseEntity{
	
	@CreationTimestamp
	@Column(name="added_On")
	private LocalDate addedOn;
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Product products;
	
	@ManyToOne
	@JoinColumn(name="Customer_id")
    private User curUser;
    private int quantity;
    
    @Transient
    public double getTotalOfProduct() {
    	return products.getUnitPrice()*quantity;
    }
	

}
