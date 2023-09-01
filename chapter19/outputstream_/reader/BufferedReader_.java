package com.hspedu.chapter19.outputstream_.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 * bufferedReader的使用
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "src/com/hspedu/chapter19/story.txt";
        //创建bufferedReader对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取,效率高
        while ((line = bufferedReader.readLine()) != null){//返回null时表示读取完毕
            System.out.println(line);
        }
        //关闭流，只需要关闭外层流即可，因为底层会自动关闭节点流
        bufferedReader.close();


    }
}
