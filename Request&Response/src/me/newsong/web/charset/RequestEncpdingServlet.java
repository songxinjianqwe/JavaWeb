package me.newsong.web.charset;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestEncpdingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("原编码："+request.getParameter("username"));
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("调整后编码："+username);
		
		System.out.println("原编码："+request.getParameter("password"));
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("调整后编码："+password);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println(username);
		System.out.println(password);
		System.out.println(Arrays.toString(hobbies));
	}

}
