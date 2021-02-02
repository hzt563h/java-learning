package com.hzt.demo.jvm;

public class MyStackOverflowError {
    public static int recursivePrint(int num) {
        System.out.println("Number: " + num);

        if(num == 0){
            return num;
        }
        else{
            recursivePrint(++num);
        }
        return 0;
    }
    //启动参数-Xss1M
    public static void main(String[] args) {
        MyStackOverflowError.recursivePrint(1);
    }
}
