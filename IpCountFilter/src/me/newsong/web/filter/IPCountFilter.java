package me.newsong.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IPCountFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String ip = request.getRemoteAddr();
		Map<String,Integer> map = (Map<String, Integer>) request.getServletContext().getAttribute("ipCount");
		Integer count = map.get(ip);
		if(count == null){
			map.put(ip, 1);
		}else{
			map.put(ip, count+1);
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

}
