package me.newsong.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import me.newsong.utils.CommonUtils;

public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置缓存大小和临时目录
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024,new File(request.getServletContext().getRealPath("/WEB-INF/temp")));
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(1024*1024);//限制单个文件大小最大为1M
		fileUpload.setSizeMax(5*1024*1024);//限制所有上传文件总大小最大为5M
		List<FileItem> files = null;
		request.setCharacterEncoding("utf-8");//虽然直接从request取数据是无效的，但是这个upload组件会调用这个方法
		try {
			files = fileUpload.parseRequest(request);
			for (FileItem item : files) {
				if (item.isFormField()) {
					response.getWriter().print(item.getFieldName() + ":" + item.getString() + "<br>");
				} else {
					response.getWriter().print(item.getFieldName() + ":" + item.getName() + "<br>");
					String root = request.getServletContext().getRealPath("/WEB-INF/uploads");
					//文件名的哈希码的16进制字符串
					String hex = Integer.toHexString(item.getName().hashCode());
					File dirFile = new File(root,"/"+hex.charAt(0)+"/"+hex.charAt(1));
					dirFile.mkdirs();//创建文件族，两层目录，最多创建256个文件夹
					item.write(new File(dirFile,
							CommonUtils.uuid() +"_"+ item.getName()));
				}
			}
		}catch(FileSizeLimitExceededException e){
			request.setAttribute("msg", "单个文件过大！");
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		}catch(SizeLimitExceededException e){
			request.setAttribute("msg", "总体文件过大！");
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
