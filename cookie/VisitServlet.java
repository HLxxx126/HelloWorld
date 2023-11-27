package com.itheima.cookie;

import java.io.IOException;
import java.sql.Date;
import com.itheima.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * ユーザーの前回の訪問時刻を記録するServlet
 */
@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	/**
     * ユーザーがServletを訪問する
     * 初回の訪問すれば
     * ”こんにちわ、当サイトへようこそ。”と顕示されだ
     * 現在のアクセス時間を記録し、Cookieに保存してブラウザに書き戻す
     * 初回の訪問ではない場合
     * Cookieから前回の時間をと取得し、ページに表示します
     * 現在のアクセス時間を記録し、Cookieに保存してzに書き戻す
     */
    	//初回の訪問がまいがを判断する：指定されたCookieの配列から指定された名前のCookieを取得する
    	//ブラウザに携帯した全部のCookieを取得する
        Cookie[] cookies = request.getCookies();
      //配列内名前が指定されたCookieを探す
        Cookie cookie = CookieUtils.findCookie(cookies, "Visit");
        //初回の訪問かどうかを判断する
        if (cookie == null) {
			//初回の訪問だ
        	//”こんにちわ、当サイトへようこそ。”と顕示されだ
			response.setContentType("text/html;charset=UTF-8");//中文
			response.getWriter().println("<h1>こんにちわ、当サイトへようこ</h1>");
        }else {
			//初回の訪問ではない
			//Cookieから前回の時間をと取得し、ページに表示します
			String value = cookie.getValue();
			response.setContentType("text/html;charset=UTF-8");//中文
			response.getWriter().println("<h1>こんにちわ、前回の訪問時間は:"+ value + "</h1>");
		}
        //現在のアクセス時間を記録し、Cookieに保存してブラウザに書き戻す
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String currentTimeString = dateFormat.format(d);
        System.out.print("LIU"+currentTimeString);
        Cookie c = new Cookie("Visit", currentTimeString);
        //Cookieに有効なパスを設定する
        c.setPath("/web02");
        //Cookieに有効期間を設定する
        c.setMaxAge(60 * 60);//有効期間は１時間に設定する
        response.addCookie(c);
    	}
    

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
}
