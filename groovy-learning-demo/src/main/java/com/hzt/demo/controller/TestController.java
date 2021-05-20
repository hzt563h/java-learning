package com.hzt.demo.controller;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.*;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author hzt
 * @version 1.0.0
 * @ClassName TestController.java
 * @createTime 2021年05月11日 11:34:00
 */
@RestController
public class TestController {
    GroovyObject groovyObjectFromFile;
    public TestController() {

        GroovyClassLoader loader = new GroovyClassLoader();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:Hello.groovy");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Class groovyClass = null;
        try {
            groovyClass = loader.parseClass(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            groovyObjectFromFile = (GroovyObject) groovyClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("test3")
    public String test3(@RequestParam("param") String param) throws ScriptException {
        return groovyObjectFromFile.invokeMethod("transform", param).toString();
    }
}
