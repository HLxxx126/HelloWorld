package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HLxxx
 * @version 1.0
 */
//リクエスト処理クラス
    @RestController
public class HelloController {
        @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World~");
        return "Hello World~";
    }
}
