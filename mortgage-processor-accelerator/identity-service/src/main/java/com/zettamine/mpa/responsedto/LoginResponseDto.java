package com.zettamine.mpa.responsedto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResponseDto 
{
	private String userName;
	
	private String token;

}
