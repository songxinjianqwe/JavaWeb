package me.newsong.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeFirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("IncludeFirstServlet");
		response.setHeader("key", "value");
		request.setAttribute("hehe", "dadada");
		response.getWriter().println("Visiting IncludeFirstServlet...");
		request.getRequestDispatcher("/IncludeSecondServlet").include(request, response);
	}

}
