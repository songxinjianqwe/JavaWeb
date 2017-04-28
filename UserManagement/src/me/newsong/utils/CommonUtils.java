package me.newsong.utils;

import java.util.Map;
import java.util.UUID;

import me.newsong.domain.User;

public class CommonUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 表单数据封装为一个对象
	 * 
	 * @param properties
	 * @param clazz
	 * @return T
	 */
	public static User toBean(Map<String, String[]> properties, Class<User> clazz) {
		User user = new User();
		for(Map.Entry<String, String[]> entry:properties.entrySet()){
			if(entry.getKey().equals("username")){
				user.setUsername(entry.getValue()[0]);
			}else if(entry.getKey().equals("password")){
				user.setPassword(entry.getValue()[0]);
			}else if(entry.getKey().equals("verifyCode")){
				user.setVerifyCode(entry.getValue()[0]);
			}
		}
		return user;
	}

}
