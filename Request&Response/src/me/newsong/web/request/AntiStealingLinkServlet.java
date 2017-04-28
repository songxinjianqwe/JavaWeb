package me.newsong.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AntiStealingLinkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String referer = request.getHeader("Referer");
		System.out.println(referer);
		if(referer == null || !referer.contains("localhost")){
			response.sendRedirect("http://www.baidu.com");
		}else{
			response.getWriter().print("hello");
		}
	}
}
