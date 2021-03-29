package com.hzt.demo.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName ObjectFor3D.java
 * @createTime 2021年03月29日 17:52:00
 */
public class ObjectFor3D implements Subject {
    private List<MyObserver> observers = new ArrayList<MyObserver>();
    private String msg;
    @Override
    public void registerObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        int index = observers.indexOf(observer);
        if (index >= 0)
        {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (MyObserver observer : observers)
        {
            observer.update(msg);
        }
    }
    public void setMsg(String msg)
    {
        this.msg = msg;

        notifyObservers();
    }
}
