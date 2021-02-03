package com.hzt.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName FileDemo.java
 * @Description TODO
 * @createTime 2021年02月03日 17:43:00
 */
public class FileDemo {
    /**
     * 递归地列出一个目录下所有文件
     * @param dir
     */
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    /**
     * 文件复制
     * @param src
     * @param dist
     * @throws IOException
     */
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }

        in.close();
        out.close();
    }
}
