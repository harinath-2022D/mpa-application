package com.zettamine.mpa.responsedto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDto 
{
	private HttpStatus StatusCode;
	private String StatusMessage;

}