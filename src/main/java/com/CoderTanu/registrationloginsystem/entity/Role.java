package com.CoderTanu.registrationloginsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique =true)
	private String name;
	
	@ManyToMany(mappedBy="role")
	private List<User> user = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Role(Long id, String name, List<User> user) {
		this.id = id;
		this.name = name;
		this.user = user;
	}
	
	public Role() {
		
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", user=" + user + "]";
	}

}
