package com.zettamine.mpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginDto 
{
	@Email
	private String userName;

	@NotNull(message = "password should not be Null. Please fill it")
	@NotBlank(message = "password should not be Blank. Please fill it")
	private String password;
}
