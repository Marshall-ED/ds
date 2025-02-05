package org.example.queue;

import org.example.queue.MyQueue;

/**
 * @Author Marshall
 * @Date 2024/10/20 23:58
 * @Description:
 */
public class TestMyQueue {
    public static void main(String[] args) {
        //创建一个队列
        MyQueue myQueue = new MyQueue();
        //入队
        myQueue.add(9);
        myQueue.add(8);
        myQueue.add(7);
        //出队
        System.out.println(myQueue.poll());
        myQueue.add(6);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
    }
}
