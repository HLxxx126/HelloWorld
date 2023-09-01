package com.hspedu.chapter19.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 * 使用Properties类来创建配置文件，修改配置文件内容
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //创建k-v
        //如果该文件没有key就是创建，如果key已存在，就是修改
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");//保存的是中文的unicode码值
        properties.setProperty("pwd","abc111");
        //将k-v存储到文件中
        properties.store(new FileOutputStream("src/mysql2.properties"),null);
        System.out.println("保存成功");

        ;
    }
}
