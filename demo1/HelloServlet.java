package com.itheima.servlet.demo1;

import java.io.IOException;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	//顧客のリクエストを処理し、リクエストに対する応答を行うたのメソッド
	public void service(ServletRequest res, ServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Hello Servlet");
		
	}	
}
