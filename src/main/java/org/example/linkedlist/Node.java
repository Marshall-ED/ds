package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2024/10/21 17:00
 * @Description:单链表
 */
public class Node {
    //节点内容
    int data;
    //下个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //为节点追回节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        //循环向后找
        while (true) {
            //取出下一个节点
            Node nextCode = currentNode.next;
            //如果下一个节点为Null,当前节点已经是最后一个节点
            if (nextCode == null) {
                break;
            }
            //赋给当前节点
            currentNode = nextCode;
        }
        //把需要追加的节点追为找到的当前节点的下一个节点
        currentNode.next = node;
        return this;
    }

    //删除下一个节点
    public void removeNext() {
        //先取出下下一个节点
        Node newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }
    //插入一个节点,作为当前节点的下一个节点
    public void after(Node node){
        //取出下一个节点，作为下下一个节点
        Node nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next=node;
        //把下下一个节点设置为新节点的下一个节点
        node.next=nextNext;
    }

    //显示所有节点信息
    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            //取出下一个节点
            currentNode=currentNode.next;
            //如果是最后一个节点
            if (currentNode==null) {
                break;
            }
        }
        System.out.println();
    }

    //获取下一个节点
    public Node next() {
        return this.next;
    }

    //获取节点的数据
    public int getData() {
        return this.data;
    }

    //最后一个节点
    public boolean isLast() {
        return next == null;
    }


}
