package org.example.stack;

/**
 * @Author Marshall
 * @Date 2025/2/17 15:33
 * @Description:
 */
public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedListNode linkedListNode = new LinkedListNode();

        linkedListNode.push(1);
        linkedListNode.push(2);
        linkedListNode.push(3);
        linkedListNode.list();
        System.out.println("取出一个元素后~");
        linkedListNode.pop();
        linkedListNode.list();

    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedListNode {

        private Node top;//栈顶

        public LinkedListNode() {
            top = null;//初始化栈顶为空
        }

        //栈空
        public boolean isEmpty() {
            return top == null;
        }

        //入栈
        public void push(int value) {
            Node newNode = new Node(value);//创建一个结点
            newNode.next = top;//新节点指向当前栈顶
            top = newNode;//更新栈顶为新节点
        }

        //出栈
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空");
            }
            int value = top.value;//获取栈顶元素
            top = top.next;//往下替换栈顶
            return value;
        }

        //遍历栈
        public void list() {
            if (top == null) {
                System.out.println("栈为空~");
            }
            Node temp = top;

            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }

        }
    }


}
