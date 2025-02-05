package org.example.array;

import org.example.util.MyArray;

/**
 * @Author Marshall
 * @Date 2024/9/25 15:06
 * @Description:
 */
public class TestMyArray {
    public static void main(String[] args) {
        //创建一个可变的数组
        MyArray ma = new MyArray();
        //获取长度
        int size = ma.size();
        //往可变数组中添加一个元素
        ma.add(99);
        ma.add(98);
        ma.add(97);
        //显示可变数组中的所有元素到控制台
        ma.show();
        ma.delete(0);
        ma.show();
        //取出指定位置的元素
        int element = ma.get(0);
        System.out.println(element);
        System.out.println("---------------------------------");
        //插入指定元素
        ma.add(96);
        ma.add(95);
        ma.add(94);
        ma.add(93);
        ma.show();
        ma.insert(3,33);
        ma.show();
        System.out.println("---------------------------------");
        ma.set(0,100);
        ma.show();
        System.out.println(ma.size());
    }
}
