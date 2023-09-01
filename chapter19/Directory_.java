package com.hspedu.chapter19;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author HLxxx
 * @version 1.0
 * 目录操作
 */
public class Directory_ {
    public static void main(String[] args) {

    }
    //判断src/com/hspedu/chapter19/news2.txt是否存在，如果存在就删除
    @Test
    public void m1(){
        String filePath = "src/com/hspedu/chapter19/news2.txt";
        File file = new File(filePath);
        if (file.exists()){
          if (file.delete()){
              System.out.println("删除成功");
          }else {
              System.out.println("删除失败");
          }
        }else {
            System.out.println("文件不存在。。");
        }
    }
    //判断src/com/hspedu/chapter19/demo02 是否存在，存在就删除，否则提示不存在
    //在java编程中，目录也被当成文件
    @Test
    public void m2(){
        String filePath = "src/com/hspedu/chapter19/demo02";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("该目录不存在。。");
        }
    }
    //判断src/com/hspedu/chapter19/demo/a/b/目录是否存在，如果存在就提示已存在，否则就创建
    @Test
    public void m3(){
        String directoryPath = "src/com/hspedu/chapter19/demo/a/b/c";
        File file = new File(directoryPath);
        if (file.exists()){
            System.out.println("该目录已存在");
        }else {

           if (file.mkdirs()){//创建一级目录用mkdir（），创建多级目录用mkdirs（）
               System.out.println("创建成功");
           }else{
               System.out.println("创建失败");
           }
        }
    }
}
