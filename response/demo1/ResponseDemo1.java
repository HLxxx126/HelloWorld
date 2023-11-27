package com.itheima.response.demo1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * レスバンスのステータスコードを設定する
 * ステータスコードとLocationヘッダーを使用してリダイレクトを完了する
 * 定期的なリフレッシュ
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setStatus(404);
		//してリダイレクトを完了する
		//response.setStatus(302);
		//レスバンスヘッダーを設定する
		//response.setHeader("Location", "/web01/ResponseDemo2");
		//定期的なリフレッシュ
		//response.setContentType("text/html;charset=UTF-8");//中文字符集
		response.getWriter().println("５秒後、ページがダイレクトされます");
		response.setHeader("Refresh", "5;url=/web01/ResponseDemo2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
