package com.hzt.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName OOMError.java
 * @Description TODO
 * @createTime 2020年12月04日 16:41:00
 */
public class OOMError {
    static class OOMObject{
        public int[] arrayList=new int[100*100*100];
    }
    //启动参数-Xms256M -Xmx256M
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while(true) {
            list.add(new OOMObject());
        }
    }

}
