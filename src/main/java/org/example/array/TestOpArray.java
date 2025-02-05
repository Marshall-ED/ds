package org.example.array;

import java.util.Arrays;

/**
 * @Author Marshall
 * @Date 2024/9/23 15:48
 * @Description: 解决数组的长度不可变的问题
 */
public class TestOpArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7};
        //快速查看数组中的元素
        System.out.println(Arrays.toString(arr));
        //要加入数组的目标元素
        int dst = 6;
        //创建一个新的数组，长度是原数组长度+1
        int[] newArr = new int[arr.length + 1];
        //开始循环，先把旧数组的值复制到新数组，留出arr.length+1
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        //将目标元素赋值到最后一个位置，因为下标从0开始所以新数组的最后一个位置就是旧数组的长度
        newArr[arr.length] = dst;
        //新数组替换原数组
        arr = newArr;
        System.out.println(Arrays.toString(arr));
    }
}
