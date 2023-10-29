package com.config.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull()
	@Size(min=4, message = "Your name must be 4 character")
	private String userName;
	
	@Email(message = "Email Format not valid")
	@Column(unique = true)
	private String email;
	
	@Size(min = 8,max = 50, message = "Password should be atleast 8 character")
	private String password;
	
	@Size(min = 10,max = 10, message = "Mobile number should be 10 Digits")
	@Column(unique = true)
	private String mobileNumber;
}