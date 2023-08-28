package com.app.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;

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
public class NewPasswordDto {

	@NotNull
	private String email;

	@NotNull
	private String password;

	

	
	
	
}
