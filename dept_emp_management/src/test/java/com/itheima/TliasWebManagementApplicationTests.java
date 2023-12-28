package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }



    //生成jwt令牌
    @Test
    public void testGenJwt(){
       Map<String,Object> claims = new HashMap<>();
       claims.put("id",1);
       claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "hlxxx") //设置签名算法
                .setClaims(claims) //自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为一个小时
                .compact();
        System.out.println(jwt);
    }

    //解析JWT
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("hlxxx")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwMzY2NTQ4MX0.QGMPkj2Lgs6smu-1B-Y2yizV6cRWiEPpBDjCe9iR6xQ")
                .getBody();
        System.out.println(claims);

    }
}
