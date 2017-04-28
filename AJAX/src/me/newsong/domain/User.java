package me.newsong.domain;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private Date birthday;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String username, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + "]";
	}
	
}
