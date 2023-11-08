package com.cbp.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	@Id
	private String adminId;
	@OneToOne(cascade = CascadeType.ALL)
	private Users users;

	public Admin() {
	
	}

	public Admin(String adminId, Users users) {

		this.adminId = adminId;
		this.users = users;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", users=" + users + "]";
	}
}