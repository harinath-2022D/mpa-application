package com.zettamine.mpa.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(schema = "mpa" ,name="users",uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User extends BaseEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer userId;
	    
	
    private String email;
		
	private String password;
		
	private String firstName;
		
	private String lastName;
		
	private String dateOfBirth;
		
	private String gender;
		
	private String phoneNo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "mpa" ,name = "users_roles",
	           joinColumns = {@JoinColumn(name="userId")},
	           inverseJoinColumns = {@JoinColumn(name="roleId")}
	)
	private Set<Roles> roles = new HashSet<>();
}
