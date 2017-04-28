package me.newsong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.createRandomCode(response.getOutputStream());
		request.getSession().setAttribute("verifyCode", verifyCode.getCode());
		System.out.println("VerifyCodeServlet:"+request.getAttribute("verifyCode"));
	}
}
