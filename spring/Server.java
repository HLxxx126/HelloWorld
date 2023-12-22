package com.itheima;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


/**
 * @author HLxxx
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server is running...");
        while (true) {
            Socket sock = ss.accept();
            System.out.println("connected from" + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }
}
class Handler extends Thread{
    Socket sock;
    public Handler(Socket sock){
        this.sock = sock;
    }
    public void run(){
        try {
            InputStream input = this.sock.getInputStream();
            OutputStream output = this.sock.getOutputStream();
            handle(input,output);
        } catch (IOException e) {
            try {
                this.sock.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("client disconnected.");
        }
    }
    private void handle(InputStream input,OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        boolean requestOk = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")){
            requestOk = true;
        }
        for (;;){
            String header = reader.readLine();
            if (header.isEmpty()){
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");

        if (!requestOk){
            writer.write("HTTP/1.0 404 Not Found \r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        }else {
            InputStream is = Server.class.getClassLoader().getResourceAsStream("html/a.html");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder data = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();
            int length = data.toString().getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Connection:keep-alive\r\n");
            writer.write("Content-Type: test/html\r\n");
            writer.write("Content-Length: "+length+"\r\n");
            writer.write("\r\n");
            writer.write(data.toString());
            writer.flush();
        }

    }
}