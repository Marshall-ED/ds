package org.example.array;

import java.util.Arrays;

/**
 * @Author Marshall
 * @Date 2024/9/25 14:12
 * @Description:如何删除数组中的元素
 */
public class TestOpArray2 {
    public static void main(String[] args) {
        //目标数组
        int[] arr = new int[]{9, 8, 7, 6, 5, 4};
        System.out.println(Arrays.toString(arr));
        //要删除的元素下标
        int dst = 1;
        //创建一个新数组，长度是原数组的长度-1
        int[] newArr = new int[arr.length - 1];
        //复制原数组中除了要输出的那个元素意外的其他元素
        for (int i =0;i< newArr.length;i++){
            //要删除的元素之前的元素,按顺序放入
            if (i<dst){
                newArr[i]=arr[i];
            }else {
                //要删除的元素之后的元素，用加1的方式跳过目标元素，不用担心超出的问题
                newArr[i]=arr[i+1];
            }
        }
        //新数组替换旧数组
        arr=newArr;
        System.out.println(Arrays.toString(arr));
    }
}
