package com.hzt.demo.observer;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName ObServerTest.java
 * @createTime 2021年03月29日 19:01:00
 */
public class ObServerTest {
    public static void main(String[] args) {
        //模拟一个3D的服务号
        ObjectFor3D subjectFor3d = new ObjectFor3D();
        //客户1
        MyObserver observer1 = new ObServerTwo(subjectFor3d);
        MyObserver observer2 = new ObServerOne(subjectFor3d);

        subjectFor3d.setMsg("20140420的3D号码是：127" );
        subjectFor3d.setMsg("20140421的3D号码是：333" );

    }
}
