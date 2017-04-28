package me.newsong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.domain.User;
import me.newsong.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPasword(request.getParameter("password"));
		UserService service = new UserService();
		User storedUser = service.login(user);
		if(storedUser != null){
			request.getSession().setAttribute("user", storedUser);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
