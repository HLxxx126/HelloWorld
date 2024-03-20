package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.username,passwordを受け取ります。
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //チェックボックスのデータを取得します。
        String remember = request.getParameter("remember");

        //2.サービスを呼び出して検索します。
        User user = service.login(username, password);

        if (user != null) {
            //ロクイン成功した,全てを検索するページに移動します。
            //ログイン成功後のユーザーオブジェクトをセッションに保存します。
            ////ユーザーが「記憶する」をチェックしたかどうかを判断します。
            if ("1".equals(remember)){
                //チェックボックスを選択した、Cookieを送信します
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                response.addCookie(c_username);
                response.addCookie(c_password);

            }

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        } else {
            //ロクイン失敗
            //エラーメッセージをリクエストに保存します。
            request.setAttribute("login_msg","ユーザー名またはパスワードが間違っています");
            //ロクインページに移動します
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
