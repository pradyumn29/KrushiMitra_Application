package com.app.Dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.Entities.Address;
import com.app.Entities.Categories;
import com.app.Entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class ProductDto {

	    @NotBlank
		private String prodname;
	    
	   @NotBlank
		private String prodDesc;
	    
	   @NotBlank
		private double unitPrice;
	    
	   @NotBlank
		private int prodQuantity;
	    
	
		@NotBlank@NotNull
		private String imageUrl;
	
		@NotNull
		private double prodWeight;
		
		@NotBlank
		private String Specification;
		
		@NotBlank
		private LocalDate mfgDate;
		
		@JsonIgnore
		private Categories prodCategory;
}
