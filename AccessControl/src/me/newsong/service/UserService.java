package me.newsong.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import me.newsong.domain.User;

public class UserService {
	private static Map<String,User> users = new ConcurrentHashMap<>();
	static{
		users.put("admin", new User("admin","admin",2));
		users.put("user", new User("user","user",1));
	}
	
	public UserService() {
	}
	
	public User login(User user){
		System.out.println("User:"+user);
		User storedUser = users.get(user.getUsername());
		System.out.println("StoredUser:"+storedUser);
		if(storedUser == null || !storedUser.getPasword().equals(user.getPasword())){
			return null;
		}
		return storedUser;
	}
}
