package com.zettamine.mpa.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRolesDto 
{
	
	@Email
	private String userName;
	
	/*
	 * @NotNull(message = "password should not be Null. Please fill it")
	 * 
	 * @NotBlank(message = "password should not be Blank. Please fill it") private
	 * String password;
	 */
	
	@NotNull(message = "Roles cannot be Null")
	@NotEmpty(message = "Roles cannot be Empty")
	@Size(min = 1, message = "At least one role must be specified")
	private List<String> roles;
	
	
	

}
