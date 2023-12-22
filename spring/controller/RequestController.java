package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
@RestController
public class RequestController {
    //元の方法
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        //リクエストパラメータを取得する
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + ":" + age);
//        return "OK";
//    }
    //SpringBootの方法

    // @RequestMapping("/simpleParam")
////    public String simpleParam(String name, Integer age){
////        System.out.println(name + ":" + age);
////        return "OK";
////    }
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name") String username, Integer age) {
        System.out.println(username + ":" + age);
        return "OK";
    }

    //2.エンティティ パラメータ
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK";
    }

    //3.配列パラメータ
    @RequestMapping("/arrayParam")
    public String arrayPara(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //コレクションパラメータ
    @RequestMapping("/listParam")
    public String listPara(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    //4.日時パラメータ
    @RequestMapping("/dataParam")
    public String dataPara(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    //5.jsonパラメータ
    @RequestMapping("/jsonParam")
    public String jsonPara(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }
    //6.パスパラメータ
    @RequestMapping("/path/{id}")
    public String pathPara(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }
    @RequestMapping("/path/{id}/{name}")
    public String pathPara2(@PathVariable Integer id,@PathVariable String name) {
        System.out.println(id + ":" + name);
        return "OK";
    }
}
