package com.zettamine.mpa.serviceimpl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.mpa.dto.RolesDto;
import com.zettamine.mpa.entities.Roles;
import com.zettamine.mpa.exceptions.ResourceAlreadyExistException;
import com.zettamine.mpa.mapper.Mapper;
import com.zettamine.mpa.repository.RolesRepository;
import com.zettamine.mpa.service.IRoleService;
import com.zettamine.mpa.utility.StringOperator;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public boolean saveRole(RolesDto rolesDto) {
		
		Optional<Roles> role = rolesRepository.findByRole(StringOperator.replaceAndTrim(rolesDto.getRole()));
		
		if(role.isPresent())
		{
			throw new ResourceAlreadyExistException("Role Already Exist");
		}
		
		Roles roleObj = Mapper.mapToRole(rolesDto,new Roles());
		Roles save = rolesRepository.save(roleObj);
		
		return true;
	}

}
