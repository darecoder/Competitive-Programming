package com.company._05_DynamicProgramming;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], curr_max+nums[i]);
            max = Math.max(max, curr_max);
        }
        return max;
    }
}
