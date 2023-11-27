package com.itheima.servlet.demo1;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{

	@Override
	public void destroy() {
	//Servletはさーばーから削除されるが、またはサーバーがシャットダウンされると、Servletが破棄されます　一度だけ実行されます
		System.out.println("ServletDemo1は破棄された");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//Servletオブジェクトがインスタンス化されると、initメソッドが実行され、しかも一度だけ実行されます
		System.out.println("ServletDemo1はインスタンス化された");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
      //どのリクエストserviceメソッドが実行され、複数回実行できます
		System.out.println("ServletDemo1は実行された");
	}

}
