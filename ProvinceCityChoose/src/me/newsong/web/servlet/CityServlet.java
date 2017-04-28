package me.newsong.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.dao.LocationDao;
import me.newsong.domain.City;
import net.sf.json.JSONArray;

public class CityServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		LocationDao dao = new LocationDao();
		String province = request.getParameter("province");
		System.out.println(province);
		List<City> cities = null;
		try {
			cities = dao.findByProvince(Integer.parseInt(province));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(cities);
		JSONArray arr = JSONArray.fromObject(cities);
		System.out.println(arr.toString());
		response.getWriter().print(arr.toString());
	}
}
