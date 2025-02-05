package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2024/10/21 17:25
 * @Description:
 */
public class TestNode {
    public static void main(String[] args) {
        //创建节点
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        //追加节点
        n1.append(n2).append(n3).append(new Node(4));


//        //取出下一个节点的数据
//        System.out.println(n1.next.next.getData());
//        //判断节点是否为最后一个节点
//        System.out.println(n1.next.next.next.isLast());

        //显示所有节点内容
        n1.show();
        //删除一个节点
//        n1.next().removeNext();
//        n1.show();
        //插入一个新节点
        Node n5 = new Node(5);
        n1.next.after(n5);
        n1.show();

    }
}
