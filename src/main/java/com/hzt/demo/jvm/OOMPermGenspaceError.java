package com.hzt.demo.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName OOMPermGenspaceError.java
 * @Description TODO
 * @createTime 2020年12月07日 09:55:00
 */
public class OOMPermGenspaceError extends ClassLoader {
    //启动参数-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
    public static void main(String[] args) {
       int j=0;
        try {
            OOMPermGenspaceError error = new OOMPermGenspaceError();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter对象，用于生成累的二进制字节码
                ClassWriter classWriter=new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                byte[] code =classWriter.toByteArray();
                error.defineClass("Class"+i,code,0,code.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }

    }
    static class OOMobject{}
}
