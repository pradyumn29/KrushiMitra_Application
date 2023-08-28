package com.app.Dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.Entities.Address;
import com.app.Entities.CartItem;
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
public class UserDto {

	    @JsonProperty(access = Access.READ_ONLY)
     	private Long id;
	    @NotNull@NotBlank
		private String firstname;
	    
	    @NotNull@NotBlank
		private String lastname;
	    @Email@NotBlank
		private String email;
	    @JsonProperty(access = Access.WRITE_ONLY)
		private String password;
	    @NotNull
		private int age;
	    @NotNull
		private long contactNumber;
	    
		private LocalDate DOB;
	    
		private Role role;
	
		//private Address address;
		
		private int house_number;
		
		private int street_number;

		private String AddressLine1;
	
		private String AddressLine2;
	
		private String City;
		
		private String state;
	
		private int postalcode;
		
		private String country;
		
}
