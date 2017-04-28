package me.newsong.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.dao.LocationDao;
import me.newsong.domain.Province;
import net.sf.json.JSONArray;

public class ProvinceServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		LocationDao dao = new LocationDao();
		List<Province> provinces = null;
		try {
			provinces = dao.findAllProvinces();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray arr = JSONArray.fromObject(provinces);
		System.out.println(arr.toString());
		response.getWriter().print(arr.toString());
	}
}
