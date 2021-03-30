package com.hzt.demo.array;

import java.util.Arrays;

/**
 * 题目描述
 * 现有一个NxN的矩阵，阶数为N，请编写一个算法将矩阵顺时针旋转90度并将其作为返回值。
 * 要求不使用缓存矩阵，保证N不大于500，元素不大于256，每个元素用int表示。
 *
 *
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class TransformImage {
    public int[][] transformImage(int[][] mat, int n) {
        int[][] array=new int[n][n];
        if (mat==null || n==0){
            return array;
        }
        int a=0;
        for (int i = 0; i < n; i++) {
            int b=0;
            for (int j = n-1; j >=0 ; j--) {
                System.out.println(j+","+i);
                array[a][b]=mat[j][i];
                b++;
            }
            a++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] mat =new int[][]
                {
                        {1,2,3},{4,5,6},{7,8,9}
                };
        TransformImage image = new TransformImage();
        int[][] image1 = image.transformImage(mat, 3);
        System.out.println(Arrays.toString(image1));
    }
}
