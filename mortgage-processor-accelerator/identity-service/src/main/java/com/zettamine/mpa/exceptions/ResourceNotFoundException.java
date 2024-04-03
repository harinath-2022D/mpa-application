package com.zettamine.mpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{

	public ResourceNotFoundException(String resource,String role ) {
		super(role.toUpperCase() + " "+resource+" Does not Exist");
		
	}
	

}
