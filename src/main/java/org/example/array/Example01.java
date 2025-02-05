package org.example.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Marshall
 * @Date 2025/1/13 15:35
 * @Description:
 */
public class Example01 {

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 9, 5, 7, 4, 3, 8};

        //全部元素递增排序
        Arrays.sort(a);

        for (int i = 1; i < a.length; i++) {
            System.out.println(i);
        }


        Integer[] b = {6, 2, 1, 9, 5, 7, 4, 3, 8};

        //全部元素递减排序
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (Integer x : b) {
            System.out.println(x);
        }

        int[] c = {6, 2, 1, 9, 5, 7, 4, 3, 8};

        //将[2...6)范围内的元素递增排序
        Arrays.sort(c,2,6);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

    }


}
