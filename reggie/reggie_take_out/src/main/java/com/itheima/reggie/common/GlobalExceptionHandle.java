package com.itheima.reggie.common;

import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause.ReturnRowsClause;

import lombok.extern.slf4j.Slf4j;

/**
 * グローバル例外処理
 * 
 * @author dreammtank125
 *
 */
@ControllerAdvice(annotations = { RestController.class })
@ResponseBody
@Slf4j
public class GlobalExceptionHandle {
	/**
	 * 例外処理の方法
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
		log.error(ex.getMessage());
		if (ex.getMessage().contains("Duplicate entry")) {
			String[] split = ex.getMessage().split(" ");
			String msg = "ユーザー名" + split[2] + "は既に存在します";
			return R.error(msg);
		}
		return R.error("未知のエラーが発生しました");
	}

	/**
	 * カスタムのビジネス例外処理の方法
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CustomException.class)
	public R<String> exceptionHandler(CustomException ex) {
		log.error(ex.getMessage());

		return R.error(ex.getMessage());
	}

}
