package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2024/12/17 13:25
 * @Description:单项链表类
 */
public class LinkedList {

    //头节点
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * 向链表末尾添加节点
     *
     * @param value
     */
    public void append(int value) {
        //新节点
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
        } else {
            //现在的节点等于头节点
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * 打印链表
     */
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    /**
     * 往链表头部插入节点
     */
    public void insertAtHead(int value) {
        //一个新的节点
        ListNode newNode = new ListNode(value);
        //将新节点的next指针指向原来的头节点
        newNode.next = head;
        //将头节点更新为新节点
        head = newNode;
    }

    /**
     * 往链表指定位置插入节点
     *
     * @param preNode 前一个节点
     * @param value   值
     */
    public void insertAfterNode(ListNode preNode, int value) {
        if (preNode == null) {
            System.out.println("The given preNode cannot be null");
            return;
        }
        //一个新的节点
        ListNode newNode = new ListNode(value);

        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    /**
     * 往链表的末尾插入新节点
     *
     * @param value
     */
    public void insertAtTail(int value) {
        insertAfterNode(getLastNode(), value);
    }

    private ListNode getLastNode() {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedList testList1 = new LinkedList();
        testList1.append(1);
        testList1.append(2);
        testList1.append(3);
        testList1.printList();

        //--------------------------------------------------

        testList1.insertAtHead(5);
        testList1.printList();

        //--------------------------------------------------

        ListNode head1 = testList1.head;
        testList1.insertAfterNode(head1, 8);
        testList1.printList();

        //--------------------------------------------------

        testList1.insertAtTail(10);
        testList1.printList();

    }
}
