package me.newsong.utils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理编码问题
		//处理请求编码
		request.setCharacterEncoding("UTF-8");
		//处理响应编码
		response.setContentType("text/html;charset=utf-8");
		
		String methodName = request.getParameter("method");
		if(methodName == null || methodName.isEmpty()){
			System.out.println("未输入方法名");
			throw new RuntimeException("Do nou input methodName");
		}
		
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("未找到"+methodName+"方法");
			throw new RuntimeException("can not find "+methodName);
		}
		String result = null;
		try {
			result = (String) method.invoke(this, request,response);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println(methodName+ "方法内部抛出异常");
			throw new RuntimeException(e);
		}
		if(result != null){
			String [] strs = result.split(":");
			String type = strs[0],path = strs[1];
			if(type.equals("f")){
				request.getRequestDispatcher(path).forward(request, response);
			}else if(type.equals("r")){
				response.sendRedirect(request.getContextPath()+path);
			}else{
				throw new RuntimeException(type+" has not been supported");
			}
		}
	}
}
