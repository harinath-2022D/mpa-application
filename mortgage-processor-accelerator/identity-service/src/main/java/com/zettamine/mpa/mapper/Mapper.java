package com.zettamine.mpa.mapper;


import com.zettamine.mpa.dto.RolesDto;
import com.zettamine.mpa.dto.UserDto;
import com.zettamine.mpa.entities.Roles;
import com.zettamine.mpa.entities.User;
import com.zettamine.mpa.utility.StringOperator;

public class Mapper 
{

	public static Roles mapToRole(RolesDto rolesDto, Roles roles) {
		
		roles.setRole(StringOperator.replaceAndTrim(rolesDto.getRole()));
		roles.setDescription(StringOperator.replaceAndTrim(rolesDto.getDescription()).toLowerCase());
		
		return roles;
	}

	public static User mapToUser(UserDto userDto, User user) 
	{
		
		user.setEmail(StringOperator.replaceAndTrim(userDto.getEmail()).toLowerCase());
		user.setFirstName(StringOperator.replaceAndTrim(userDto.getFirstName()));
		user.setLastName(StringOperator.replaceAndTrim(userDto.getLastName()));
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setGender(StringOperator.replaceAndTrim(userDto.getGender()));
		user.setPhoneNo(userDto.getPhoneNo());
		
		return user;
	}
	

}
