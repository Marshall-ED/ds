package org.example.util;

import java.util.Arrays;

/**
 * @Author Marshall
 * @Date 2024/9/25 14:57
 * @Description:
 */
public class MyArray {
    //用于存储数据的数组
    private int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    /**
     * 获取数组长度的方法
     */
    public int size() {
        return elements.length;
    }

    /**
     * 往数组的末尾添加一个元素
     *
     * @param element
     */
    public void add(int element) {
        //创建一个新的数组
        int[] newArr = new int[elements.length + 1];
        //把原数组的元素复制到新数组中
        for (int i = 0; i < elements.length; i++) {

            newArr[i] = elements[i];

        }
        //把添加的元素放入新数组中
        newArr[elements.length] = element;
        //使用新数组替换旧数组
        elements = newArr;
    }


    /**
     * 打印所有元素到控制台
     */
    public void show() {
        System.out.println(Arrays.toString(elements));
    }


    /**
     * 删除数组中的元素
     *
     * @param index
     */
    public void delete(int index) {
        //判断下标是否越界
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
        //创建一个新的数组，长度为原数组的长度-1
        int[] newArr = new int[elements.length - 1];
        //复制所有数组到新数组
        for (int i = 0; i < newArr.length; i++) {
            //目标删除元素前面的元素
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                //目标删除元素后面的元素
                newArr[i] = elements[i + 1];

            }
        }
        //新数组替换旧数组
        elements = newArr;
    }

    /**
     * 取出指定位置的元素
     *
     * @param index
     * @return 返回指定下标的elements
     */
    public int get(int index) {
        return elements[index];
    }

    /**
     * 插入一个元素到指定位置
     *
     * @param index   插入元素下标
     * @param element 插入元素元素
     */
    public void insert(int index, int element) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
        //创建一个新的数组
        int[] newArr = new int[elements.length + 1];
        //将原数组中的元素放入到新数组中
        for (int i = 0; i < elements.length; i++) {
            //目标位置之前的元素
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                //目标位置之后的元素
                newArr[i + 1] = elements[i];
            }
        }
        //插入新的元素
        newArr[index] = element;
        //新数组替换旧数组
        elements = newArr;
    }

    /**
     * 替换指定位置的元素
     *
     * @param index
     * @param element
     */
    public void set(int index, int element) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
        elements[index] = element;
    }

    /**
     * 线性查找
     */
    public int search(int target) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找
     */
    public int binarySearch(int target) {
        //记录开始位置
        int begin = 0;
        //记录结束位置
        int end = elements.length - 1;
        //记录中间位置
        int mid = begin + (end - begin) / 2;
        //循环查找
        while (true) {
            //什么情况下没有这个元素？
            //开始在结束位置之后或重合
            //判断中间这个元素是不是要查找的元素
            if(begin>end){
                return -1;
            }
            if (elements[mid] == target) {
                return mid;
                //中间这个元素不是要查找的元素
            } else {
                //判断中间这个元素是不是比目标元素大
                if (elements[mid] > target) {
                    //把结束位置调整到中间位置的前一个位置
                    end = mid - 1;
                    //判断中间这个元素是不是比目标元素小
                } else {
                    //把开始位置调整到中间位置的后一个位置
                    begin = mid + 1;
                }
                //取出新的中间位置
                mid = begin + (end - begin) / 2;
            }
        }
    }

}
