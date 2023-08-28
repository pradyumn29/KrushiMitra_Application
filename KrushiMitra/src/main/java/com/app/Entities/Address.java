package com.app.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
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
public class Address extends BaseEntity {
	
	private int house_number;
	@NotNull
	private int street_number;
	@Column(length=100)
	@NotBlank
	private String AddressLine1;
	@Column(length=100)
	private String AddressLine2;
	@Column(length=30)
	@NotBlank
	private String City;
	@Column(length=30)
	@NotBlank
	private String state;
	@NotNull
	private int postalcode;
	@Column(length=30)
	@NotBlank
	private String country;
	
//	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
////	@MapsId
//	private User user;
}
