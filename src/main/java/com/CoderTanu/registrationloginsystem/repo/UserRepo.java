package com.CoderTanu.registrationloginsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CoderTanu.registrationloginsystem.entity.User;



public interface UserRepo  extends JpaRepository<User , Long>{
	
	String findByEmail(String email);

}
