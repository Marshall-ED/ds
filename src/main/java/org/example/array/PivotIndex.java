package org.example.array;

/**
 * @Author Marshall
 * @Date 2024/9/3 12:39
 * @Description:找出数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class PivotIndex {
    //线性搜索：时间复杂度为O(n)
    public int solution(int[] nums) {
        //1、存储所有元素的总和
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        //2.左侧*2加上中间下标的值如果等于总和，表示找到中心下标，如果不匹配则会更新左侧和
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == totalSum) {
                return i;//找到中心下标
            }
            leftSum += nums[i];//更新左侧和
        }
        return -1;//如果没有中心下标，返回-1
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();

        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};
        int[] nums4 = {2, 1, -1, 5, 0, 3};

        System.out.println("nums1的中心下标是：" + pivotIndex.solution(nums1));
        System.out.println("nums2的中心下标是：" + pivotIndex.solution(nums2));
        System.out.println("nums3的中心下标是：" + pivotIndex.solution(nums3));
        System.out.println("nums4的中心下标是：" + pivotIndex.solution(nums4));

    }

}
