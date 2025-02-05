package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2024/10/21 17:00
 * @Description:单链表
 */
public class LoopNode {
    //节点内容
    int data;

    //下个节点
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }

    //删除下一个节点
    public void removeNext() {
        //先取出下下一个节点
        LoopNode newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }
    //插入一个节点,作为当前节点的下一个节点
    public void after(LoopNode node){
        //取出下一个节点，作为下下一个节点
        LoopNode nextNext = this.next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next=nextNext;
    }


    //获取下一个节点
    public LoopNode next() {
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
