package me.newsong.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.dao.LocationDao;
import me.newsong.domain.Area;
import net.sf.json.JSONArray;

public class AreaServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		LocationDao dao = new LocationDao();
		String city = request.getParameter("city");
		List<Area> areas = null;
		try {
			areas = dao.findByCity(Integer.parseInt(city));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray arr = JSONArray.fromObject(areas);
		System.out.println(arr.toString());
		response.getWriter().print(arr.toString());
	}
}
