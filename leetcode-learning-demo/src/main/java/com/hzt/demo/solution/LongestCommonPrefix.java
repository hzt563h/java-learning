package com.hzt.demo.solution;

import java.util.HashSet;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName LongestCommonPrefix.java
 * @createTime 2021年04月22日 17:57:00
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        HashSet<String> set = new HashSet<>();
        int sum=0;
        for (String str : strs) {
            sum+=str.length();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                set.add(String.valueOf(chars[i]));
            }
        }
        return "";
    }
}
