package com.CB.DynamicProgramming;

import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = {3, 6, 2};      //Set of numbers given
        int sum = 10;           // Given sum

        boolean[][] mem = new boolean[nums.length+1][sum+1];
//        System.out.println(subsetSum(nums,nums.length-1, sum));
        System.out.println(subsetSumDP(nums,sum,mem));
    }

    public static boolean subsetSum(int[] nums, int n, int sum) {
        // Base condition
        if(sum == 0){
            return true;
        }

        if(sum > 0 && n < 0){
            return false;
        }

        // Boundary condition
        if(sum < nums[n]){
            return subsetSum(nums, n+1, sum);
        }
        // Main Recursive call
        return subsetSum(nums, n-1, sum-nums[n]) || subsetSum(nums, n-1, sum);
    }

    public static boolean subsetSumDP(int[] nums, int sum, boolean[][] mem) {
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j == 0){
                    mem[i][j] = true;
                }else if(i == 0){
                    mem[i][j] = false;
                }else if(j < nums[i-1]){
                    mem[i][j] = mem[i-1][j];
                }else {
                    mem[i][j] = mem[i-1][j] || mem[i-1][j-nums[i-1]];
                }
            }
        }
        return mem[nums.length][sum];
    }
}
