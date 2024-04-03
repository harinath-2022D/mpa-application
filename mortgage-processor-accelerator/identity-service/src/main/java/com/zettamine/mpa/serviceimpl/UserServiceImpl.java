package com.zettamine.mpa.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zettamine.mpa.dto.UserDto;
import com.zettamine.mpa.entities.Roles;
import com.zettamine.mpa.entities.User;
import com.zettamine.mpa.exceptions.ResourceAlreadyExistException;
import com.zettamine.mpa.exceptions.ResourceNotFoundException;
import com.zettamine.mpa.mapper.Evaluator;
import com.zettamine.mpa.mapper.Mapper;
import com.zettamine.mpa.repository.UserRepository;
import com.zettamine.mpa.service.IUserService;
import com.zettamine.mpa.utility.StringOperator;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private Evaluator evaluator;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean saveUser(UserDto userDto) 
	{
		Optional<User> userName = userRepository.findByEmail(StringOperator.replaceAndTrim(userDto.getEmail()).toLowerCase());
		if(userName.isPresent())
		{
			throw new ResourceAlreadyExistException("UserName Already Exist.");
		}
		
		if(userDto.getUserRoles() != null)
		{
		 Set<Roles> roles = evaluator.validateRoles(userDto.getUserRoles());
		 
		 User userObj =  Mapper.mapToUser(userDto,new User());
		 userObj.setPassword(encoder.encode(userDto.getPassword()));
		 userObj.setRoles(roles);
		 
		 User save = userRepository.save(userObj);
		 return true;
		 
		}
		
		User user = Mapper.mapToUser(userDto, new User());
		user.setPassword(encoder.encode(userDto.getPassword()));
		
		userRepository.save(user);
		return true;
	}

}
