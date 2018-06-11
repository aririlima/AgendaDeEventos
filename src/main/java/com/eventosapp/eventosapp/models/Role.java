package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements Serializable, GrantedAuthority{

	private static final long serialVersionUID= 1L;
	
	@Id
	private String roleId;

	@ManyToMany
    private List<User> user;
	
	@Override
	public String getAuthority() {

		return roleId;
	}


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}


}
