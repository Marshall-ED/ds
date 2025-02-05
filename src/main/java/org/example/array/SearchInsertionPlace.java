package org.example.array;

/**
 * @Author Marshall
 * @Date 2024/9/3 19:54
 * @Description:搜索插入位置 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 */
public class SearchInsertionPlace {
    //二分法搜索：时间复杂度是O(log n)
    public int solution(int[] nums, int target) {
        //1、初始化left和right，分别指向数组的起始和结束位置
        int left = 0;
        int right = nums.length;//nums.length结束位置
        //2、使用while循环，当left小于right时，进行二分查找
        while (left < right) {
            //3、计算中间下标mid，比较nums[mid]和target大小
            int mid = left + (right - left) / 2;
            //4、如果nums[mid]小于target，则将left指针移动到mid+1的位置
            //5、否则，将right指针移动到mid位置
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertionPlace searchInsertionPlace = new SearchInsertionPlace();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Index: " + searchInsertionPlace.solution(nums, target));

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Index: " + searchInsertionPlace.solution(nums2, target2));
    }
}
