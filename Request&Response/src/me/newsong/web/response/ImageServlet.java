package me.newsong.web.response;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class ImageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		byte[] image = IOUtils.toByteArray(new FileInputStream(this.getServletContext().getRealPath("/images/cat.jpeg")));
		response.getOutputStream().write(image);
	}
}
