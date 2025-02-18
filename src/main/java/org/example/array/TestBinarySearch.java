package org.example.array;



/**
 * @Author Marshall
 * @Date 2024/10/15 21:42
 * @Description:二分法查找，效率高但应用少，必须要有序数组
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        //目标数组
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //目标元素
        int target = 2;
        //记录开始位置
        int begin = 0;
        //记录结束位置
        int end = arr.length - 1;
        //记录中间位置
        int mid = begin + (end - begin) / 2;
        //记录目标位置
        int index = -1;
        //循环查找
        while (end > begin) {
            //判断中间这个元素是不是要查找的元素
            if (arr[mid] == target) {
                index = mid;
                break;
                //中间这个元素不是要查找的元素
            } else {
                //判断中间这个元素是不是比目标元素大
                if (arr[mid] > target) {
                    //把结束位置调整到中间位置的前一个位置
                    end = mid - 1;
                    //判断中间这个元素是不是比目标元素小
                } else {
                    //把开始位置调整到中间位置的后一个位置
                    begin = mid + 1;
                }
                //取出新的中间位置
                mid=begin + (end - begin) / 2;
            }
        }
        System.out.println("index:" + index);
    }

}
