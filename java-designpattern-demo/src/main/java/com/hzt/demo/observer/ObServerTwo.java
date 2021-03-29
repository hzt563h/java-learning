package com.hzt.demo.observer;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName ObServerTwo.java
 * @createTime 2021年03月29日 17:55:00
 */
public class ObServerTwo implements MyObserver {
    private Subject subject;

    public ObServerTwo(Subject subject)
    {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg)
    {
        System.out.println("ObServerTwo 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
