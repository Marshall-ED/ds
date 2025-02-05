package org.example.array;

import java.util.Arrays;

/**
 * @Author Marshall
 * @Date 2025/1/15 18:42
 * @Description:有一个含n个整数的一维数组a，设计一个算法求任意两个元素差的绝对值的最小值
 */
public class Mind {
    public static int Min(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        //a[n-1]是最后一位；a[0]是第一位
        int d = a[n - 1] - a[0];// 初始化为最大可能差值

        for (int i = 1; i < n; i++) {// 索引从1开始，因为第一个元素没有前一个元素可以比较
            if (a[i] - a[i - 1] < d) {
                d = a[i] - a[i - 1];
            }
        }
        return d;
    };

    public static void main(String[] args) {
        int[] a = {-5,-2,3,6,2};
        int min = Min(a);
        System.out.println(min);
    }
}
