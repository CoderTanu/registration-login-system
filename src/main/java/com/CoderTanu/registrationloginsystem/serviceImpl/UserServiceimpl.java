package com.CoderTanu.registrationloginsystem.serviceImpl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.CoderTanu.registrationloginsystem.dto.UserDto;
import com.CoderTanu.registrationloginsystem.entity.Role;
import com.CoderTanu.registrationloginsystem.entity.User;
import com.CoderTanu.registrationloginsystem.repo.RoleRepo;
import com.CoderTanu.registrationloginsystem.repo.UserRepo;
import com.CoderTanu.registrationloginsystem.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	
	private UserRepo userRepo;
	private RoleRepo roleRepo;
	
   
	public UserServiceimpl(UserRepo userRepo, RoleRepo roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo=roleRepo;
	}



	@Override
	public void saveUser(UserDto userdto) {
		User user = new User();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		
		Role role = roleRepo.findByName("ROLE_ADMIN");
		
		if(role ==null) {
			role =checkRoleExist();
		}
		
		user.setRole(Arrays.asList(role));
		userRepo.save(user);
		
	}
	
	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepo.save(role);
		
	}

}
