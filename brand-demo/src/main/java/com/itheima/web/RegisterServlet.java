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
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.username,passwordを受け取ります。
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //ユーザーが入力した検証コードを取得します
        String checkCode = request.getParameter("checkCode");
        //セッションから生成された検証コードを取得します。
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("codeGen");

        if (!code.equalsIgnoreCase(checkCode)){//忽略大小写
            //登録は許可されていません。
            request.setAttribute("register_msg","認証コードが間違っています");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }




        boolean flag = service.register(user);

        if (flag){
            request.setAttribute("register_msg","登録が成功しました。ログインしてください。");

            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","ユーザー名は既に存在しています");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
