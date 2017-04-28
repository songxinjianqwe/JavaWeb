package me.newsong.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.domain.User;
import me.newsong.service.UserService;
import me.newsong.utils.CommonUtils;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		UserService service = new UserService();
		User realUser = service.findByUsername(user.getUsername());
		if (realUser == null || !user.getPassword().equals(realUser.getPassword())) {
			request.setAttribute("status", "用户名或密码错误");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("username", user.getUsername());
			Cookie cookie = new Cookie("username", user.getUsername());
			response.addCookie(cookie);
			cookie.setMaxAge(60*60);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}
