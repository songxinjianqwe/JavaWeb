package me.newsong.service;

import me.newsong.dao.UserDAO;
import me.newsong.domain.User;
import me.newsong.exception.UsernameExistedException;

public class UserService {
	private UserDAO userDAO;
	public UserService() {
		userDAO = new UserDAO();
	}
	public User findByUsername(String username){
		return userDAO.findByUsername(username);
	}
	
	public void addUser(User user) throws UsernameExistedException{
		if(findByUsername(user.getUsername()) != null){
			throw new UsernameExistedException();
		}
		userDAO.addUser(user);
	}
}
