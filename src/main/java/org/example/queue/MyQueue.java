package org.example.queue;

/**
 * @Author Marshall
 * @Date 2024/10/20 23:43
 * @Description:队列
 */
public class MyQueue {
    int[] elements;

    public MyQueue() {
        elements = new int[0];
    }

    //入队
    public void add(int element) {
        //创建一个新数组,长度是原来数组+1
        int[] newArr = new int[elements.length + 1];
        //把原数组中的元素复制到新数组中
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        //把添加的元素放入新数组中
        newArr[elements.length] = element;
        //将新数组放回旧数组
        elements = newArr;

    }

    //出队
    public int poll() {
        //把数组中的第0个元素取出
        int element = elements[0];
        //创建一个新的数组
        int[] newArr = new int[elements.length - 1];
        //复制原数组中的元素到新数组中
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i + 1];
        }
        //替换数组
        elements = newArr;
        return element;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
