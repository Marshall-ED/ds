package org.example.array;

/**
 * @Author Marshall
 * @Date 2025/1/17 22:51
 * @Description:
 */
public class Example03 {
    public static int[] addition(int[] nums, int target) {



        //i < nums.length - 1 相当于为j预留了一个值遍历
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }


        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int target = 9;
        int [] nums = new int[]{2,11,7,25,4,6};

        int[] n = addition(nums, target);

        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }

    }
}
