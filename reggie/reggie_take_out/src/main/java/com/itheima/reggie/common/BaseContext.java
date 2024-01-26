package com.itheima.reggie.common;

/**
 * ThreadLocalに基づいたユーティリティクラス,現在ログインしているユーザーのIDを保存および取得するのユーティリティクラスです。
 * @author dreammtank125
 *
 */
public class BaseContext {
	private static ThreadLocal<Long> threadLocal =  new ThreadLocal<>();
		
	public static void setCurrentId(Long id) {
		threadLocal.set(id);
	}
	
	public static Long getCurrentId() {
		return threadLocal.get();
	}

}
