package com.hzt.demo.file;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName NIOClient.java
 * @Description TODO
 * @createTime 2021年02月04日 09:40:00
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
