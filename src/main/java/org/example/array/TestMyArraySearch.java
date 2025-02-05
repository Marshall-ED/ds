package org.example.array;

import org.example.util.MyArray;

import java.util.ArrayList;

/**
 * @Author Marshall
 * @Date 2024/10/16 14:48
 * @Description:
 */
public class TestMyArraySearch {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
        ma.add(1);
        ma.add(2);
        ma.add(3);
        ma.add(4);
        ma.add(5);
        //调用线性查找方法
        int index = ma.search(3);
        System.out.println("index:"+index);
        //调用二分法查找
        int binaryIndex = ma.binarySearch(3);
        System.out.println("binaryIndex："+binaryIndex);
    }
}
