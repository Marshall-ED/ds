package org.example.stack;

/**
 * @Author Marshall
 * @Date 2024/10/19 22:45
 * @Description:
 */
public class TestMyStack {
    public static void main(String[] args) {
        //创建一个栈
        MyStack myStack = new MyStack();
        //压入数组
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
        //取出栈顶元素
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.peek());
    }
}
