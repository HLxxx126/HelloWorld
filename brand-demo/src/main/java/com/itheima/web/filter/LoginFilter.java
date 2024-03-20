package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * @author HLxxx
 * @version 1.0
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //アクセスされたリソースパスがログインや登録に関連しているかどうかを判断します
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","register.jsp","/registerServlet","/checkCodeServlet"};
        //現在のアクセスされているリソースのパスを取得します
        String url = req.getRequestURL().toString();
        //セッションにユーザーが存在するかどうかを判断します
        HttpSession session = req.getSession();
        for (String u : urls) {
            if (url.contains(u)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        Object user = session.getAttribute("user");
        if (user != null){

            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            req.setAttribute("login_msg","ログインされていません");
            req.getRequestDispatcher("/login.jsp").forward(req,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
