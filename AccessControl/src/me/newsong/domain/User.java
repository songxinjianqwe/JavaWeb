package me.newsong.domain;

public class User {
	private String username;
	private String pasword;
	private int grade;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String pasword, int grade) {
		super();
		this.username = username;
		this.pasword = pasword;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", pasword=" + pasword + ", grade=" + grade + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
