package com.hspedu.chapter19.Homework19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        String filePath = "src/com/hspedu/chapter19/story.txt";
        BufferedReader br = null;
        String line = " ";
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line =br.readLine())!=null){
                System.out.println(++lineNum + line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
