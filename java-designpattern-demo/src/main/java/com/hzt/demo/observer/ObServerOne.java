package com.hzt.demo.observer;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName ObServerOne.java
 * @createTime 2021年03月29日 17:55:00
 */
public class ObServerOne implements MyObserver {
    private Subject subject;

    public ObServerOne(Subject subject)
    {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg)
    {
        System.out.println("ObServerOne 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
