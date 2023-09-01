package com.hspedu.chapter19.writer_;

import java.io.*;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ButteredCopy_ {//不能操作二进制文件（声音，视频，doc，pdf等）
    public static void main(String[] args) {
        String scrFileOath = "src/com/hspedu/chapter19/story.txt";
        String destFileOath = "src/com/hspedu/chapter19/newStory.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(scrFileOath));
            bw = new BufferedWriter(new FileWriter(destFileOath));
            //读取
            while ((line =br.readLine()) != null){
                //每读取一行就写入
                bw.write(line);
                //插入换行
                bw.newLine();
            }
            System.out.println("拷贝完毕。。。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                if (br != null){
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
