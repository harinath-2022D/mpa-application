package com.zettamine.mpa.dto;


import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDto 
{
	
	private Integer userId;
	
	@Email
	private String email;
	
	@NotNull(message = "Password should not be Null. Please fill it")
	@NotBlank(message = "Password should not be Blank. Please fill it")
	private String password;
	
	@NotNull(message = "FirstName should not be Null. Please fill it")
	@NotBlank(message = "FirstName should not be Blank. Please fill it")
	private String firstName;
	
	@NotNull(message = "LastName should not be Null. Please fill it")
	@NotBlank(message = "LastName should not be Blank. Please fill it")
	private String lastName;
	
	@Pattern(regexp = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$",message = "Date of birth should be in the format DD-MM-YYYY")
	private String dateOfBirth;
	
	@NotNull(message = "Gender should not be Null. Please fill it")
	@NotBlank(message = "Gender should not be Blank. Please fill it")
	private String gender;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$")
	private String phoneNo;
	
	
	private Set<String> userRoles ;
	
	
}
