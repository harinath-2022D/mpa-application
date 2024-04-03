package com.zettamine.mpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RolesDto 
{
	
	@NotBlank(message = "role should not be Blank. Please fill it")
	@NotNull(message = "role should not be Null. Please fill it")
	private String role;
	
	@NotBlank(message = "Description should not be Null. Please fill it")
	@NotBlank(message = "Descreption should not be Blank. Please fill it")
	private String description;

}
