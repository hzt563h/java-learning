package com.hzt.demo.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName UrlDemo.java
 * @Description TODO
 * @createTime 2021年02月03日 17:54:00
 */
public class UrlDemo {
    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.baidu.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
