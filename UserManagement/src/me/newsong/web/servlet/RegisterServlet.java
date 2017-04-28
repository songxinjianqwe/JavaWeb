package me.newsong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.domain.User;
import me.newsong.exception.UsernameExistedException;
import me.newsong.service.UserService;
import me.newsong.utils.CommonUtils;

public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		System.out.println(user);
		UserService service = new UserService();
		String verifyCode = (String) request.getSession().getAttribute("verifyCode");
		if(!user.getVerifyCode().trim().toUpperCase().equals(verifyCode)){
			request.setAttribute("status", "验证码错误");
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			return ;
		}else{
			try{
				service.addUser(user);
			}catch(UsernameExistedException e){
				request.setAttribute("status", "用户名重复");
				request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			}
		}
		response.getWriter().print("注册成功!");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
