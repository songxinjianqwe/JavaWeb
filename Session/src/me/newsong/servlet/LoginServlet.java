package me.newsong.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin")) {
			// 使用session保存信息，可以使用重定向，因为处于同一会话
			// 避免Servlet的路径出现在地址栏中
			
			//保存一个session的域
			request.getSession().setAttribute("username", username);
			//保存一个cookie
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24);//一天
			response.addCookie(cookie);
			response.sendRedirect("/Session/jsp/succ1.jsp");
		} else {
			// 使用request保存信息，只能使用转发，因为处于同一请求
			request.setAttribute("status", "用户名或密码错误");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

}
