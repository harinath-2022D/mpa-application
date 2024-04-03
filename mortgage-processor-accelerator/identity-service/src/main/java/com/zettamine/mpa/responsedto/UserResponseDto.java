package com.zettamine.mpa.responsedto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponseDto
{
//    private Integer userId;
    
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String gender;
	
	private String phoneNo;
	

}
