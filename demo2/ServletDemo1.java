package com.itheima.servlet.demo2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//もしGetリクエストであれば、’DoGet'メソっド内のコードが実行されます
		doPost(req, resp);//相互呼び出しでプログラムを簡略化する
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//もしPostリクエストであれば、’DoPost'メソっド内のコードが実行されます
		resp.getWriter().println("ServlrtDemo1...");
	}

	
}
