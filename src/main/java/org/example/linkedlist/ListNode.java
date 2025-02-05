package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2024/12/17 13:24
 * @Description: 定义链表的节点类
 */
public class ListNode {
    //节点内容
    int value;

    //下一个节点
    ListNode next;


    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
