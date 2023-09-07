package com.hspedu.chapter21.homework21;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        String answer = "";
        if ("name".equals(s)){
            answer = "HLxxx";
        }else if ("hobby".equals(s)){
            answer = "singing";
        } else {
            answer = "你说的啥子";
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(answer);
        writer.newLine();
        writer.flush();

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();


    }
}
