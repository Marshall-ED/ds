package org.example.linkedlist;

/**
 * @Author Marshall
 * @Date 2025/2/6 20:28
 * @Description:
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //双向链表的测试
        HeroNode2 hero1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改测试
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况: ");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况: ");
        doubleLinkedList.list();

        System.out.println("按顺序添加后的情况: ");
        HeroNode2 hero5 = new HeroNode2(3, "林冲", "豹子头");
        doubleLinkedList.addByOrder(hero5);
        doubleLinkedList.list();
    }

    //创建一个双向链表的类
    static class DoubleLinkedList {

        //先初始化一个头结点，头结点不要动，不存放具体的数据
        private HeroNode2 head = new HeroNode2(0, "", "");

        //返回头节点
        private HeroNode2 getHead() {
            return head;
        }

        //显示链表【遍历】
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //头结点不包含数据，从下一个开始遍历；遍历需要展示数据
            HeroNode2 temp = head.next;

            while (temp != null) {

                //输出结点信息
                System.out.println(temp);

                //将temp的指针后移到下一个结点
                temp = temp.next;
            }
        }

        //添加一个结点到双向链表的最后
        public void add(HeroNode2 heroNode) {

            //因为头结点不能动，因此需要一个辅助遍历temp;添加操作必须从头结点开始否则无法找到最后一个结点
            HeroNode2 temp = head;

            //遍历链表找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后；将新结点添加到链表末尾
            //形成一个双向链表
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        //根据编号添加结点到双向链表
        public void addByOrder(HeroNode2 heroNode){

            HeroNode2 temp = head;
            //标志添加的编号是否存在，默认为false
            boolean flag = false;

            while (true) {
                //说明temp已经在链表的最后
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > heroNode.no) { //位置找到
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
                //插入到链表中
                heroNode.next = temp.next;
                heroNode.pre = temp;
                if (temp.next != null) {
                    temp.next.pre = heroNode;
                }
                temp.next = heroNode;


            }
        }

        //修改结点，根据no编号来修改，即no编号不能改；双向链表的结点内容和单向链表一样
        //只是结点类型改成了HeroNode2
        //说明
        //1、根据newHeroNode的no来修改
        public void update(HeroNode2 newHeroNode) {
            //判断是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //找到需要修改的结点，根据no编号
            //定义一个辅助变量
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
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

        //从双向链表中删除一个结点
        //1、对于双向链表我们可以直接找到要删除的这个结点
        //2、找到后自我删除即可
        public void delete(int no) {

            //判断当前链表是否为空
            if (head.next == null) {
                System.out.println("链表为空无法删除");
                return;
            }

            HeroNode2 temp = head.next;//辅助指针
            boolean flag = false;//标志是否找到待删除结点

            while (true) {

                if (temp == null) {//链表最后
                    break;
                }
                if (temp.no == no) {//如果前一个结点的下一个和编号相同
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if (flag) {//找到
                //可以删除
                //temp.next = temp.next.next;[单向链表删除方式]
                temp.pre.next = temp.next;

                //这里有问题？
                //如果是最后一个结点，就不要执行下面这句话，否则出现空指针异常
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.printf("%d该结点不存在", no);
            }
        }


    }

    //定义HeroNode2 ， 每个HeroNode对象就是一个结点
   static class HeroNode2 {
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;//指向下一个节点，默认为null
        public HeroNode2 pre;//指向前一个节点，默认为null

        //构造方法
        public HeroNode2(int hNo, String hName, String hNickName) {
            this.no = hNo;
            this.name = hName;
            this.nickName = hNickName;
        }

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' + "}";
        }
    }
}
