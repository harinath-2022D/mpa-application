package com.zettamine.mpa.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.mpa.dto.UserDto;
import com.zettamine.mpa.responsedto.ResponseDto;
import com.zettamine.mpa.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mpa/user")
public class UserController 
{
	@Autowired
	private IUserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDto> saveUser(@Valid @RequestBody UserDto userDto)
	{
		boolean saveUser = userService.saveUser(userDto);
		
		if(saveUser)
		{
			ResponseDto dto = new ResponseDto();
			dto.setStatusCode(HttpStatus.CREATED);
			dto.setStatusMessage("Successfully saved");
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		}
		return null;
		
	}

}
