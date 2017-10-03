package com.noname.interest.SpringBootCrudDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	public User() {}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username='" + username + '\'' +
			", password='" + password + '\'' +
			'}';
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
