package com.amandal97.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_user_id")
	private int pkUserId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

	public User() {}
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public int getPkUserId() {
		return pkUserId;
	}

	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
