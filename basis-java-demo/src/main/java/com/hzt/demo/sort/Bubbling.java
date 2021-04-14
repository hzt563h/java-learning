package com.hzt.demo.sort;

public class Bubbling {
    public static void main(String[] args) {
        int[] array={7,5,2,6,4,3};
        for (int j = array.length; j > 1; j--) {
            System.out.println("我是J====="+j);
            for (int i = 1; i <j; i++) {
                System.out.print(i);
                if (array[i-1]>array[i]){
                    int tmp=array[i-1];
                    array[i-1]=array[i];
                    array[i]=tmp;
                }
            }
            System.out.println();
            System.out.println("------一轮比较结果了输出结果");
            for (int i = 0; i <array.length; i++){
                System.out.print(array[i]+",");
            }
            System.out.println();
        }

        //输出结果查看最后排序的结果是不是正常的
        for (int i = 0; i <array.length; i++){
            System.out.print(array[i]);
        }
    }
}
