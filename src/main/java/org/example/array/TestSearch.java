package org.example.array;

/**
 * @Author Marshall
 * @Date 2024/10/12 23:13
 * @Description:线性查找，效率偏低，但应用面广
 */
public class TestSearch {
    public static void main(String[] args) {
        //目标数组
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 0};
        //目标元素
        int target = 10;
        //目标元素所在的下标
        int index = -1;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                index = i;
                break;
            }
        }

        //打印目标元素的下标
        System.out.println("index:" + index);
    }
}
