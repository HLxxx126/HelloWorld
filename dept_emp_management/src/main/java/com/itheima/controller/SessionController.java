package com.itheima.controller;

import com.itheima.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HLxxx
 * @version 1.0
 */
@Slf4j
@RestController
public class SessionController {
    //设置cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "itheima"));
        return Result.success();
    }

    //获取cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();//获取所有的cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) {//输出name为login_username的cookie
                System.out.println("login_username: " + cookie.getValue());

            }
        }

        return Result.success();
    }

    //往session中储值
    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}",session.hashCode());
        session.setAttribute("loginUser","tom");
        return Result.success();
    }
    //从HttpSession中获值
    @GetMapping("/s2")

    public Result session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}",session.hashCode());
        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser: {}",loginUser);
        return Result.success(loginUser);
    }
}

