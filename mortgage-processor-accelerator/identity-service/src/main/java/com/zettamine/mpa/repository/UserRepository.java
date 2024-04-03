package com.zettamine.mpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zettamine.mpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


	Optional<User> findByEmail(String lowerCase);

}
