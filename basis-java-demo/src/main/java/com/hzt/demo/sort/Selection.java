package com.hzt.demo.sort;

public class Selection {
    public static void main(String[] args) {
        int[] array={7,5,2,6,4,3};
        for (int j = array.length; j > 1; j--) {
            //定义第一个就是最大的
            int maxIndex=0;
            for (int i = 1; i <j; i++) {
                if (array[i]>array[maxIndex]){
                    maxIndex=i;
                }
            }
            int tmp=array[j-1];
            array[j-1]=array[maxIndex];
            array[maxIndex]=tmp;
        }

        //输出结果查看最后排序的结果是不是正常的
        for (int i = 0; i <array.length; i++){
            System.out.print(array[i]);
        }
    }
}
