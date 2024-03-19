package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author HLxxx
 * @version 1.0
 */
@WebServlet(value = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.サービスコールして検索を完了する
        List<Brand> brands = service.selectAll();
        //2.リクエストスコープに保存する
        request.setAttribute("brands",brands);
        //3.brand.jsp にフォワードする
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);  // 这里应该的get ，且是this
    }
}
