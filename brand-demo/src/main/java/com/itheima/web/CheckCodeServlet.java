package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author HLxxx
 * @version 1.0
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //キャプチャコードを生成します
        ServletOutputStream os = response.getOutputStream();
        String code = CheckCodeUtil.outputVerifyImage(100, 40, os, 4);
        //セッションに保存します。
        HttpSession session = request.getSession();
        session.setAttribute("codeGen",code);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
