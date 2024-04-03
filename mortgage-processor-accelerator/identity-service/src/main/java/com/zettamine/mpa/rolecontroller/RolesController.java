package com.zettamine.mpa.rolecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.mpa.dto.RolesDto;
import com.zettamine.mpa.service.IRoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/mpa/role")
public class RolesController {
	
	@Autowired
	private IRoleService roleService;
	
	@PostMapping("/save")
	public ResponseEntity<?>saveRole(@Valid @RequestBody RolesDto rolesDto)
	{
		boolean saveRole = roleService.saveRole(rolesDto);
		if(saveRole)
		{
			return new ResponseEntity<>("created",HttpStatus.CREATED);
		}
		return null;
		
	}

}
