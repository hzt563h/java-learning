package com.hzt.demo.base;

import java.util.Date;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2021年02月18日 11:08:00
 */
public class Person {
    private String name;
    private Integer age;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
