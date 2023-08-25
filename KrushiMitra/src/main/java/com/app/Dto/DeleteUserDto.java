package com.app.Dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

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
public class DeleteUserDto {

	
		private String email;
	  
		private String password;
}
