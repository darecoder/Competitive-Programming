package com.CB.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumEasy {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0){
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = s.nextInt();
            }

            if(subsetSum(nums, nums.length - 1, 0, new ArrayList<>())){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static boolean subsetSum(int[] nums, int n, int sum, ArrayList<Integer> list) {
        if(list.size() > 0 && sum == 0){
            return true;
        }

        if(n < 0){
            return false;
        }

        boolean reject = subsetSum(nums,n-1,sum,list);
        list.add(nums[n]);
        boolean accept = subsetSum(nums,n-1, sum - nums[n],list);
        return reject|| accept;
    }
}
