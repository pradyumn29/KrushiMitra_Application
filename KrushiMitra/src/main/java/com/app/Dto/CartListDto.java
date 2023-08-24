package com.app.Dto;

import java.util.List;

import com.app.Entities.Product;
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
public class CartListDto {

    private List<CartItemDto> cartItems;
	
	private double totalcost;
}
