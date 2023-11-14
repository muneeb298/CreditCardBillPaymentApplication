package com.cbp.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long adminId;
	

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Admin() {}

	public long getAdminId() {
		return adminId;
	}


	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Admin(long adminId, User user) {
		super();
		this.adminId = adminId;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + user + "]";
	}
	
	
	
}