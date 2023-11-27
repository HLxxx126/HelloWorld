package com.itheima.utils;

import java.util.Iterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

import jakarta.servlet.http.Cookie;

/**
 * 指定された名前のCookieを検索するためのーティリティクラス
 */
public class CookieUtils {
  public static Cookie findCookie(Cookie[] cookies, String name) {
	  if (cookies == null) {
		  //ブラウザはどのCookieも携帯していません
		return null;
	}else {
		for (Cookie cookie : cookies) {
			//配列内の各Cookieの名前が指定された名前と一致するかどうかを判断する
			if(name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
  }
}
