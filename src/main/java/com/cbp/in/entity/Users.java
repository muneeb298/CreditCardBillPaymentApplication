package com.cbp.in.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Users {
	@Id
	private String userId;
	private String password;

	public Users() {

	}

	public Users(String userId, String password) {
	
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + "]";
	}
}