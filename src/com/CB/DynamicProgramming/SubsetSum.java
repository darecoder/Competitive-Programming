package com.CB.DynamicProgramming;

import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = {32, 14, 4, 12, 45, 24};
        int sum = 19;

//        System.out.println(subsetSum(nums, nums.length-1, sum));
        System.out.println(subsetSumDP(nums,sum));
    }

    public static boolean subsetSum(int[] nums, int n, int sum) {
        if(sum == 0){
            return true;
        }

        if(sum > 0 && n < 0){
            return false;
        }

        if(sum < nums[n]){
            return subsetSum(nums,n-1,sum);
        }

        return subsetSum(nums,n-1,sum) || subsetSum(nums,n-1, sum - nums[n]);
    }

    public static boolean subsetSumDP(int[] nums, int sum){
        boolean[][] ans = new boolean[nums.length+1][sum+1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j == 0){
                    ans[i][j] = true;
                } else if (j < nums[i-1]){
                    ans[i][j] = ans[i-1][j];
                }else {
                    ans[i][j] = ans[i-1][j] || ans[i-1][j - nums[i-1]];
                }
            }
        }

        return ans[nums.length][sum];
    }
}
