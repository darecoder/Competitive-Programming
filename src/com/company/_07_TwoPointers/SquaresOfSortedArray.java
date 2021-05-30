package com.company._07_TwoPointers;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        for (int ind = n - 1; ind >= 0; ind--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[ind] = nums[left] * nums[left];
                left++;
            } else {
                result[ind] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
