package me.newsong.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = (String) request.getSession().getAttribute("fileName");
		System.out.println(fileName);
		File file = new File(this.getServletContext().getRealPath("/WEB-INF/downloads/"+fileName));
		if(!file.exists()){
			request.setAttribute("msg", "该文件不存在");
			request.getRequestDispatcher("/download.jsp").forward(request, response);
		}else{
			FileInputStream in = new FileInputStream(file);
			fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
			//注意要把文件名转为iso-8859-1，否则在浏览器下载文件时显示的文件名编码会出现问题
			//可以通过文件名称来获取MIME类型
			String contentType = this.getServletContext().getMimeType(fileName);
			String contentDisposition = "attachment;filename="+fileName;
			response.setHeader("Content-Type", contentType);
			response.setHeader("Content-Disposition", contentDisposition);
			IOUtils.copy(in, response.getOutputStream());//将字节数据从流1拷贝到流2
		}
	}
}
