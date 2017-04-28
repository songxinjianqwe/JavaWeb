package me.newsong.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//死亡之前调用
		System.out.println("ServletContext结束监听");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//出生之后调用
		System.out.println("ServletContext开始监听");
	}

}
