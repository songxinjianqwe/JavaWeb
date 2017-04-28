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
		String code = request.getParameter("code");
		String verifycode = (String) request.getSession().getAttribute("verifycode");
		if(code.trim().toUpperCase().equals(verifycode)){
			request.getSession().setAttribute("username", username);
			//保存一个cookie
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24);//一天
			response.addCookie(cookie);
			response.sendRedirect("/Login/views/succ.jsp");
		}else{
			request.setAttribute("status", "验证码错误");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
