package com.zettamine.mpa.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.zettamine.mpa.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> methodArgumentNotValidEx(MethodArgumentNotValidException ex,WebRequest webRequest)
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		dto.setApiPath(webRequest.getDescription(false));
		dto.setErrorCode(HttpStatus.BAD_REQUEST);
		dto.setErrorMessage(ex.getBindingResult().getFieldError().getField()+" : "+ex.getFieldError().getDefaultMessage());
		dto.setErrorTime(LocalDateTime.now());
		
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<ErrorResponseDto> resourceAlreadyExistEx(ResourceAlreadyExistException ex,WebRequest webRequest)
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		dto.setApiPath(webRequest.getDescription(false));
		dto.setErrorCode(HttpStatus.CONFLICT);
		dto.setErrorMessage(ex.getMessage());
		dto.setErrorTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponseDto>(dto,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> resourceNotFoundEx(ResourceNotFoundException ex, WebRequest webRequest )
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		dto.setApiPath(webRequest.getDescription(false));
		dto.setErrorCode(HttpStatus.NOT_FOUND);
		dto.setErrorMessage(ex.getMessage());
		dto.setErrorTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponseDto>(dto,HttpStatus.NOT_FOUND);
	}

}
