package me.newsong.web.listener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IpCountInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Map<String,Integer> count = new ConcurrentHashMap<>();
		event.getServletContext().setAttribute("ipCount", count);
	}
}
