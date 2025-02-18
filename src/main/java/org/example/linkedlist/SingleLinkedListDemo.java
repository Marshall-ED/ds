package org.example.linkedlist;

import java.util.Stack;

/**
 * @Author Marshall
 * @Date 2025/1/21 15:31
 * @Description:
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


        //创建一个链表
        SingledLinkedList singledLinkedList = new SingledLinkedList();

        //加入
        singledLinkedList.add(hero1);
        singledLinkedList.add(hero2);
        singledLinkedList.add(hero3);
        singledLinkedList.add(hero4);

        System.out.println("原来链表的情况：");
        singledLinkedList.list();

//        //加入按照编号
//        singledLinkedList.addByOrder(hero1);
//        singledLinkedList.addByOrder(hero3);
//        singledLinkedList.addByOrder(hero2);
//        singledLinkedList.addByOrder(hero2);
//        singledLinkedList.addByOrder(hero4);


//        //测试修改结点的代码
//        System.out.println("修改链表后的情况");
//        HeroNode newHeroNode = new HeroNode(2, "卢俊义", "小卢");
//        singledLinkedList.update(newHeroNode);
//
//
//        //显示一把
//        singledLinkedList.list();
//
//        //删除一个结点
//
//        System.out.println("删除链表后的情况");
//        singledLinkedList.delete(1);
////        singledLinkedList.delete(2);
////        singledLinkedList.delete(3);
//        singledLinkedList.delete(4);
//        singledLinkedList.list();
//
//        //求单链表中有效结点的个数
//        System.out.println("有效的结点个数= " + getLength(singledLinkedList.getHead()));
//
//        //测试是否得到倒数第k个结点
//        HeroNode res = findLastIndexNode(singledLinkedList.getHead(), 1);
//        System.out.println("res = " + res);

//        System.out.println("反转链表后的情况: ");
//        reverseList(singledLinkedList.getHead());
//        singledLinkedList.list();

//        System.out.println("测试逆序打印单链表,没有改变链表的结构~~");
//        reversePrint(singledLinkedList.getHead());

        SingledLinkedList singledLinkedList2 = new SingledLinkedList();
        HeroNode hero5 = new HeroNode(5, "松江", "及时雨");
        HeroNode hero6 = new HeroNode(7, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");
        singledLinkedList.add(hero5);
        singledLinkedList.add(hero7);
        singledLinkedList.add(hero6);
        singledLinkedList.add(hero8);

        HeroNode mergeNode = mergeTwoList(singledLinkedList.getHead(), singledLinkedList2.getHead());

        System.out.println("合并后的链表情况：");
        HeroNode temp = mergeNode;
        while (temp != null) {

            System.out.println(temp);
            temp = temp.next;

        }


    }


    //方法：获取到单链表的结点个数（如果是带头结点的链表，需求不统计头结点）

    /**
     * @param head 链表的头结点
     * @return 返回是有效节点的个数
     */
    public static int getLength(HeroNode head) {

        if (head.next == null) {//空链表
            return 0;
        }

        int length = 0;
        //定义一个辅助变量，没有统计头结点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;

    }

    ;

    //方法：查找单链表中的倒数第k个结点
    //思路
    //1、编写一个方法，接收head结点，同时接收一个index
    //2、index表示倒数第index个结点
    //3、先把链表从头到尾遍历，得到链表的总长度getLength
    //4、得到size后，我们从链表的第一个开始遍历到（size-index）个。
    //5、如果找到了，则返回该结点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //如果链表为空，返回null
        if (head.next == null) {
            return null;//没有找到
        }
        //第一个遍历到链表的长度（结点个数）
        int size = getLength(head);

        //第二次遍历 size-index的位置就是我们倒数的第k个节点
        //先做一个index的校验
        if (index < 0 || size < index) {
            return null;
        }
        //定义个辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;

        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    //方法：从尾到头打印单链表
    //思路
    //1、方式1：先将单链表进行反转操作，然后再遍历，这样做的问题是会破坏原来的单链表结构，不建议
    //2、方式2：可以利用栈这个数据结构，将各个结点压入到栈中，利用栈的先进后出的特点，实现逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表无法打印
        }
        //创建一个栈，将各个结点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        //将所有结点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//cur后移，这样就可以压入下一个结点
        }

        //将栈中的结点进行打印，pop 出栈
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }


    //方法：反转链表
    //思路
    //1、先定义一个结点reverseHead = new HeroNode();
    //2、从头到尾遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表reverseHead的最前端
    //3、原来的链表的head.next = reverseHead.next;
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个结点无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前结点【cur】的下一个结点
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表，每遍历一个结点就将其取出，并放在新的链表reversHead的最前端
        while (cur != null) {
            next = cur.next;//先暂时保存当前结点的下一个结点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个结点指向反转链表的最前端
            reverseHead.next = cur;//将当前结点插入到反转链表的最前端
            cur = next;//让cur后移

        }
        //将head.next指向reverse.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    //方法：合并两个有序链表，合并之后的链表依然有序
    public static HeroNode mergeTwoList(HeroNode head1, HeroNode head2) {

        HeroNode merge = new HeroNode(0, "", "");

        //合并后链表的结点
        HeroNode cur = merge;

        HeroNode p1 = head1.next;
        HeroNode p2 = head2.next;

        while (p1 != null && p2 != null) {
            if (p1.no < p2.no) {
                cur = p1;
                p1 = p1.next;
            } else {
                cur = p2;
                p2 = p2.next;
            }
            cur = cur.next;

        }
        if (p1 != null) {
            cur.next = p1;
        } else {
            cur.next = p2;
        }

        return merge.next;

    }

    /**
     * 定义一个SingleLinkedList管理英雄
     */
    static class SingledLinkedList {
        //先初始化一个头结点，头结点不要动，不存放具体数据
        private HeroNode head = new HeroNode(0, "", "");

        //返回头结点
        public HeroNode getHead() {
            return head;
        }

        // 添加节点到单向链表
        // 思路：当不考虑编号顺序时
        // 1. 找到当前链表的最后一个节点
        // 2. 将新节点赋值给最后一个节点的 next 属性
        public void add(HeroNode heroNode) {

            //因为头结点不能动，因此需要一个辅助遍历temp;添加操作必须从头结点开始否则无法找到最后一个结点
            HeroNode temp = head;

            //遍历链表找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后；将新结点添加到链表末尾
            temp.next = heroNode;
        }

        public void addByOrder(HeroNode heroNode) {
            //因为单链表，因此我们找的temp是位于添加位置的前一个结点，否则插入不了
            HeroNode temp = head;
            //标志添加的编号是否存在，默认为false
            boolean flag = false;

            while (true) {
                //说明temp已经在链表的最后
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > heroNode.no) { //位置找到，就在temp后面插入
                    break;
                } else if (heroNode.no == temp.next.no) { //说明希望添加的heroNode的编号已经存在
                    //说明编号存在
                    flag = true;
                }
                //指针后移
                temp = temp.next;
            }

            //判断flag的值
            if (flag) {
                System.out.printf("英雄编号%d已存在\n", heroNode.no);
            } else {
                //插入到链表中，temp的后面
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //修改结点，根据no编号来修改，即no编号不能改
        //说明
        //1、根据newHeroNode的no来修改
        public void update(HeroNode newHeroNode) {
            //判断是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //找到需要修改的结点，根据no编号
            //定义一个辅助变量
            HeroNode temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;//已经遍历完链表
                }
                //找到
                if (temp.no == newHeroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            } else {
                System.out.printf("没有找到 编号%d 的英雄，不能修改\n", newHeroNode.no);
            }

        }

        //删除结点
        //思路：
        //1、head不能动，需要一个temp辅助结点找到待删除结点的前一个结点
        //2、比对时，是temp.next.no和需要删除的几点no比较
        public void delete(int no) {
            HeroNode temp = head;
            boolean flag = false;//标志是否找到待删除结点

            while (true) {

                if (temp.next == null) {//链表最后
                    break;
                }
                if (temp.next.no == no) {//如果前一个结点的下一个和编号相同
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.printf("%d该结点不存在", no);
            }
        }

        //显示链表【遍历】
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //头结点不包含数据，从下一个开始遍历；遍历需要展示数据
            HeroNode temp = head.next;

            while (temp != null) {

                //输出结点信息
                System.out.println(temp);

                //将temp的指针后移到下一个结点
                temp = temp.next;
            }
        }


    }

    static class HeroNode {
        public int no;
        public String name;
        public String nickName;
        public HeroNode next;//指向下一个节点

        //构造方法
        public HeroNode(int hNo, String hName, String hNickName) {
            this.no = hNo;
            this.name = hName;
            this.nickName = hNickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' + "}";
        }
    }

}





