package me.newsong.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeaderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IP:"+request.getRemoteAddr());
		System.out.println("请求方式:"+request.getMethod());
		System.out.println("User-Agent请求头:"+request.getHeader("User-Agent"));
		System.out.println("协议名:"+request.getScheme());
		System.out.println("主机名:"+request.getServerName());
		System.out.println("端口号:"+request.getServerPort());
		System.out.println("项目:"+request.getContextPath());
		System.out.println("Servlet路径:"+request.getServletPath());
		System.out.println("请求参数:"+request.getQueryString());
		System.out.println("URI:"+request.getRequestURI());
		System.out.println("URL:"+request.getRequestURL());
	}

}
