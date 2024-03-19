package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author HLxxx
 * @version 1.0
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.idを受け取ります。
        String id = request.getParameter("id");
        //2.サービスを呼び出して検索します。
        Brand brand = service.selectById(Integer.parseInt(id));
        //3.リクエストに保存します。
        request.setAttribute("brand",brand);
        //4.update.jsp に転送します
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
