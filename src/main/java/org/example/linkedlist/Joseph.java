package org.example.linkedlist;



/**
 * @Author Marshall
 * @Date 2025/2/8 22:14
 * @Description:
 */
public class Joseph {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);//加入5个小孩结点
        circleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleLinkedList.countBoy(1,2,5);
    }

    //创建一个环形单向链表
    static class CircleLinkedList {
        //创建一个first结点，当前没有编号
        private Boy first = new Boy(-1);

        //添加小孩，构建成环形链表
        public void addBoy(int nums) {
            //nums 做数据校验
            if (nums < 1) {
                System.out.println("nums值不正确");
                return;
            }
            Boy curBoy = null;//辅助指针，帮助构建环形链表
            //使用for循环创建环形链表
            for (int i = 1; i <= nums; i++) {
                //根据编号创建小孩结点
                Boy boy = new Boy(i);
                //如果是第一个小孩
                if (i == 1) {
                    first = boy;
                    first.setNext(first);//构成环
                    curBoy = first;//让curBoy指向第一个小孩
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }
        }

        //遍历当前环形链表
        public void showBoy() {
            //判断链表是否为空
            if (first == null) {
                System.out.println("没有小孩");
                return;
            }
            //因为first不能动，使用辅助指针
            Boy curBoy = first;
            while (true) {
                System.out.printf("小孩的编号 %d \n", curBoy.getNo());
                if (curBoy.getNext() == first) {
                    break;
                }
                curBoy = curBoy.getNext(); //curBoy后移
            }

        }

        //根据用户的输入，计算出小孩出圈的顺序

        /**
         * @param startNo 表示第几个小孩开始数
         * @param countNo 表示数几下
         * @param nums    表示最初有多少小孩在圈中
         */
        public void countBoy(int startNo, int countNo, int nums) {
            //先对数据进行校验
            if (first == null || startNo < 1 || startNo > nums) {
                System.out.println("参数输入有误");
                return;
            }
            //创建个辅助指针，帮助完成小孩出圈，事先应该指向环形链表最后这个结点
            Boy helper = first;

            while (true) {
                if (helper.getNext() == first) {//说明helper指向最后小孩结点
                    break;
                }
                helper = helper.getNext();
            }
            //小孩报数前，先让first和helper移动k-1次
            for (int i = 0; i < startNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //当小孩报数，让first和helper指针同时移动m-1次，然后出圈
            //这里是循环操作，直到圈中只有一个结点
            while (true) {
                if (helper == first) {//说明圈中只有一个结点
                    break;
                }
                //让first和helper指针同时移动countNum - 1
                for (int i = 0; i < countNo - 1; i++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }
                //这时first指向的结点就是出圈的结点
                System.out.printf("小孩%d出圈\n", first.getNo());
                //这时将first指向的小孩出圈
                first = first.getNext();
                helper.setNext(first);
            }

            System.out.printf("最后留在圈中的小孩编号%d \n",first.getNo());
        }
    }

    //创建一个Boy类，表示一个结点
    static class Boy {
        private int no;//编号
        private Boy next;//指向下一个结点，默认为null

        public Boy(int no) {
            this.no = no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        public int getNo() {
            return no;
        }

        public Boy getNext() {
            return next;
        }
    }
}
