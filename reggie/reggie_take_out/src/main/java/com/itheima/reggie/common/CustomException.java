package com.itheima.reggie.common;

/**
 * カスタムのビジネス例外クラス
 * @author dreammtank125
 *
 */

public class CustomException extends RuntimeException{
	public CustomException(String message) {
		super(message);
	}

}
