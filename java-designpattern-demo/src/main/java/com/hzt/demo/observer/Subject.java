package com.hzt.demo.observer;

import java.util.Observer;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName Subject.java
 * @createTime 2021年03月29日 17:49:00
 */
public interface Subject {
    /**
     * 注册一个观察着
     *
     * @param observer
     */
    public void registerObserver(MyObserver observer);

    /**
     * 移除一个观察者
     *
     * @param observer
     */
    public void removeObserver(MyObserver observer);

    /**
     * 通知所有的观察着
     */
    public void notifyObservers();

}
