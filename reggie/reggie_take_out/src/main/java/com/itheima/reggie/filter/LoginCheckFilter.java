package com.itheima.reggie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーがログインしたかどうかを確認する
 *
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
	// パスマッチャー、ワイルドカードをサポート
	public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
	private static final String Long = null;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 1.今回のリクエストのURIを取得する
		String requestURI = request.getRequestURI();
		log.info("リクエスト{}がインターセプトされました", requestURI);
		// 処理される必要がないURLを定義する
		String[] urls = new String[] { "/employee/login",
				"/employee/logout",
				"/backend/**",
				"/front/**",
				"/common/**",
				"/user/sendMsg",//移动端接收短信
				"/user/login"//移动端登录
				};
		// 2.今回のリクエストが処理されるかどうかを判断する。
		boolean check = check(urls, requestURI);
		// 3.もし処理が必要でない場合は、直ちにする
		if (check) {
			log.info("今回のリクエスト{}は処理の必要がない。",requestURI);
			chain.doFilter(request, response);
			return;
		}
		// 4.1.ログイン状態を判断する、もしログインしましたの場合は、直ちにパスする
		if (request.getSession().getAttribute("employee") != null) {
			log.info("ログインしました、IDは{}",request.getSession().getAttribute("employee"));
			Long empId = (Long)request.getSession().getAttribute("employee");
			BaseContext.setCurrentId(empId);
			
			chain.doFilter(request, response);
			return;
		}
		// 4.2.ログイン状態を判断する、もしログインしましたの場合は、直ちにパスする
				if (request.getSession().getAttribute("user") != null) {
					log.info("ログインしました、IDは{}",request.getSession().getAttribute("user"));
					Long userId = (Long)request.getSession().getAttribute("user");
					BaseContext.setCurrentId(userId);
					chain.doFilter(request, response);
					return;
				}
		log.info("ログインしていません");
		// 5.もしログインしないの場合は、未ログインの結果を返し、出力ストリームを使用してクライアントページに応答データを送信します。
		response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
		return;

	}

	/**
	 * パスをマッチする、今回のリクエストがパスされるかどうかを判断する。
	 * 
	 * @param urls
	 * @param requestURL
	 * @return
	 */

	public boolean check(String[] urls, String requestURL) {
		for (String url : urls) {
			boolean match = PATH_MATCHER.match(url, requestURL);
			if (match) {
				return true;
			}
		}
		return false;
	}

}
