package com.hspedu.chapter19.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取mysql.properties文件，并得到ip，user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("src/mysql.properties"));
        String line = "";
        while ((line = br.readLine())!=null){
            String[] split = line.split("=");
            System.out.println(split[0] + "值是；" + split[1]);
        }
        br.close();
    }
}
