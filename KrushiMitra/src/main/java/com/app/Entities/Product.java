package com.app.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Product extends BaseEntity{
    @Column(length=200 ,nullable=false)
	private String prodname;
    
    @Column(length=200,nullable=false)
	private String prodDesc;
    
    @Column(length=200,nullable=false)
	private double unitPrice;
    
    @Column(nullable=false)
	private int prodQuantity;
    
	@Column(length=150)
	@NotBlank
	private String imageUrl;
	
	@Column
	@NotNull
	private double prodWeight;
	
	@Column(length=200,nullable=false)
	private String Specification;
	
	@Column
	private LocalDate mfgDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Category_id")
	private Categories prodCategory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> OrderDetails=new ArrayList<Orders>();
	   
	@JsonIgnore
	@OneToMany(mappedBy = "products", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItemList=new ArrayList<CartItem>();
	
	//helper methods
	@Transient
	public void addNewCategory(Categories CatObj) {
		this.setProdCategory(CatObj);

	}
	
}
