package me.newsong.web.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParameterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name+"="+request.getParameter(name));
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String,String[]> map = request.getParameterMap();
//		for(Entry<String,String[]> entry:map.entrySet()){
//			System.out.println(entry.getKey()+"="+Arrays.toString(entry.getValue()));
//		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String [] hobbies = request.getParameterValues("hobby");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("hobbies:"+Arrays.toString(hobbies));
		
	}
}
