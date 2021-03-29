package com.hzt.demo.base;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName MapToObject.java
 * @Description TODO
 * @createTime 2021年02月18日 10:55:00
 */
public class MapToObject {
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        T instance = beanClass.newInstance();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            Object o = map.get(field.getName());
            field.setAccessible(true);
            field.set(instance,o);
        }
        return instance;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Map<String, Object> map =new HashMap<>();
        map.put("name","name");
        map.put("age",15);
        map.put("birth",new Date());
        Person person = MapToObject.mapToObject(map, Person.class);
        System.out.println(person);
    }
}
