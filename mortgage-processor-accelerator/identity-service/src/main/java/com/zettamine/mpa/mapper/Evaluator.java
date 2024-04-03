package com.zettamine.mpa.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zettamine.mpa.entities.Roles;
import com.zettamine.mpa.exceptions.ResourceNotFoundException;
import com.zettamine.mpa.repository.RolesRepository;

@Component
public class Evaluator 
{

	@Autowired
	private RolesRepository rolesRepository;
	
	public Set<Roles> validateRoles(Set<String> userRoles) 
	{
		List<String> listRole = new ArrayList<>(userRoles);
		
		Set<Roles> roles = new HashSet<>();
		
		for (String role : listRole) 
		{
			Roles roleObj = rolesRepository.findByRole(role).orElseThrow(()->new ResourceNotFoundException("Role",role));
			roles.add(roleObj);
		}
		
		return roles;
	}
	

}
