package com.karson.webmagic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	//1.can 0.not
	private Integer canuse;
	@DBRef
	private List<Role> roles = new ArrayList<>();
//	@DBRef
	//private List<EventLog> userevenlogs = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", canuse="
				+ canuse + "]";
	}

	public Integer getCanuse() {
		return canuse;
	}

	public void setCanuse(Integer canuse) {
		this.canuse = canuse;
	}
   
	//public List<EventLog> getUserevenlogs() {
	//	return userevenlogs;
//	}

//	public void setUserevenlogs(List<EventLog> userevenlogs) {
//		this.userevenlogs = userevenlogs;
//	}

	public User() {
	}
}
