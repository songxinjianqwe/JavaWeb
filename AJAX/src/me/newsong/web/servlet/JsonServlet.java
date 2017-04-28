package me.newsong.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.domain.User;
import net.sf.json.JSONArray;

public class JsonServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User user = new User(1,"admin",new Date());
//		JSONObject json = JSONObject.fromObject(user);
//		System.out.println(json.toString());
//		response.getWriter().print(json.toString());
		
		List<User> users = new ArrayList<>();
		users.add(new User(1,"admin",new Date()));
		users.add(new User(2,"sxj",new Date()));
		JSONArray arr = JSONArray.fromObject(users);
		System.out.println(arr.toString());
		response.getWriter().print(arr.toString());
	}
}
