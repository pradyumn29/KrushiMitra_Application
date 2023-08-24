package com.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Categories extends BaseEntity {
   
	@Column(name="cat_Name",length = 50,nullable = false,unique = true)
	private String categoryName;
	
	@Column(name="cat_Desc",length = 200,nullable = false)
	private String categoryDesc;
	
	@Column(length = 150)
	private String imageUrl;
	
	@OneToMany(mappedBy = "prodCategory",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Product> ProdList=new ArrayList<Product>();
	
}
