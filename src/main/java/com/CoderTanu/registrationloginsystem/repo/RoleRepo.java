package com.CoderTanu.registrationloginsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CoderTanu.registrationloginsystem.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Role findByName(String name);

}
