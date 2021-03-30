package com.hzt.demo.link;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName GetLeastNumbers.java
 * @createTime 2021年03月30日 13:35:00
 */
public class GetLeastNumbers {
    /**
     * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbersSolution(int [] input, int k) {
        if (input==null || input.length==0 || k>input.length){
            return new ArrayList();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            arrayList.add(input[i]);
        }
        for (int i = 0; i < k ; i++) {
            int min=arrayList.get(0);
            int index=0;
            for (int i1 = 0; i1 < arrayList.size(); i1++) {
                if (arrayList.get(i1)<min){
                    min=arrayList.get(i1);
                    index=i1;
                    break;
                }
            }
            result.add(min);
            arrayList.remove(index);
        }
        return result;
    }

    public static void main(String[] args) {
        GetLeastNumbers numbers = new GetLeastNumbers();
        int[] ints = {4,5,1,6,2,7,3,8};
        System.out.println(numbers.GetLeastNumbersSolution(ints, 4));
    }
}
