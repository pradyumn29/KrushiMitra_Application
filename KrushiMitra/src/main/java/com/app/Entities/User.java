package com.app.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

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

@Entity
@Table(name="user")

@JsonIgnoreType
@Valid
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(length=30 ,nullable = false)
	private String firstname;
    
    @Column(length=30,nullable = false)
	private String lastname;
    
    @Column(length=30, unique=true)
	private String email;
    
    @Column(length=12)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,}$",
      message = "Password should meet the criteria")
	private String password;
    
    @Column(nullable=false)
	private int age;
    
    @Column(length=30,nullable = false)
	private long contactNumber;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
	private LocalDate DOB;
    
    @Enumerated(EnumType.STRING)
    @Column
	private Role role;
    
    @OneToOne
    @JoinColumn(name="user_addr")
	private Address address;
    
    @OneToMany(mappedBy ="CurUser",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> CartList=new ArrayList<CartItem>();

}
